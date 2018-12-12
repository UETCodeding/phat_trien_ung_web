package com.kat.lap_trinh_web.common.util;

import com.kat.lap_trinh_web.common.model.UserDto;
import com.kat.lap_trinh_web.common.model.UserEntity;
import com.kat.lap_trinh_web.service.impl.UserServiceImpl;
import com.kat.lap_trinh_web.service.interfaces.UserService;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.ocpsoft.rewrite.servlet.config.UserAgentUtil;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class FileUtil {
//    @Value("${system.file_upload_dir}")
//    private String fileUploadDir;

//    public String uploadFile(byte[] fileData, String fileCode) throws IOException {
//        String filePath = fileUploadDir + File.separator + fileCode + ".lap_trinh_web";
//        try (FileOutputStream fos = new FileOutputStream(filePath)) {
//            fos.write(fileData);
//        }
//        return filePath;
//    }

    private List<String> fileNames = new ArrayList<String>();
    private Workbook workbook = null;
    private String workBookName = "";

    public List<UserEntity> ExcelHelper(MultipartFile excelfile, int size, int permission){
        List<UserEntity> lstUser = new ArrayList<>();
        try {
            int i = 1;
            // Creates a workbook object from the uploaded excelfile
            XSSFWorkbook workbook = new XSSFWorkbook(excelfile.getInputStream());
            // Creates a worksheet object representing the first sheet
            XSSFSheet worksheet = workbook.getSheetAt(0);
            // Reads the data in excel file until last row is encountered
            while (i <= worksheet.getLastRowNum()) {
                // Creates an object for the UserInfo Model
                UserEntity user = new UserEntity();
                // Creates an object representing a single row in excel
                XSSFRow row = worksheet.getRow(i++);

                // Sets the Read data to the model class
                if(permission == 2){
                    int code = (int) row.getCell(1).getNumericCellValue();
                    if(code == 0){break;}
                    user.setCode(code);
                    user.setUsername(String.valueOf(code));
                    user.setTraining(row.getCell(5).getStringCellValue());
                }
                else {
                    String str = (row.getCell(1).getStringCellValue()).toString();
                    if(str == null || str.equals("") ){break;}
                    user.setUsername(str);
                    user.setCode(size +i-1);
                }
                user.setPermission(permission);
                user.setId(size + i-1);
                user.setPassword(PasswordUtil.hashMD5(String.valueOf(row.getCell(2).getNumericCellValue())));
                user.setName(row.getCell(3).getStringCellValue());
                user.setEmail(row.getCell(4).getStringCellValue());
                user.setCreatedDate(new Timestamp(new Date().getTime()));
                // persist data into database in here
                lstUser.add(user);
            }
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lstUser;

    }
    private boolean setupFileForClass(Class<?> cls) throws Exception{
        Field [] fields =cls.getDeclaredFields();
        for(int i=0;i<fields.length;i++){
            fileNames.add(fields[i].getName());
        }
        return true;
    }
    private Sheet getSheetWithName(String name){
        Sheet sheet = null;
        for(int i=0;i<workbook.getNumberOfSheets();i++){
            sheet=workbook.getSheetAt(i);
        }
        return sheet;
    }
    private Class<?> getGetterReturnClass(Class<?> cls, String fileName ){
        String methodName = "get" + capitalize(fileName);
        String methodIdName = "id" + capitalize(fileName);
        Class<?> returnType = null;
        for(Method method : cls.getMethods()){
            if(method.getName().equals(methodName) || method.getName().equals(methodIdName)){
                returnType=method.getReturnType();
                break;
            }
        }
        return returnType;
    }
    private Method constructMethod(Class<?> cls, String fileName ) throws SecurityException , NoSuchMethodException{
        Class<?> fieldClass = getGetterReturnClass(cls,fileName);
        return cls.getMethod("set" + capitalize(fileName),fieldClass);
    }

    public String capitalize(String fileName){
        String cap = fileName.substring(0,1).toUpperCase();
        return cap + fileName.substring(1);
    }
    private void initialize(){
        setWorkbook(new HSSFWorkbook());
    }
    public void initializeForReaḍ̣̣̣̣̣() throws IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
        InputStream inputStream = new FileInputStream(getWorkBookName());
        Workbook workbook = WorkbookFactory.create(inputStream);
    }

    public byte[] readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.readAllBytes(path);
    }
    @SuppressWarnings("unchecked")
    public <T> List<T> readData(String className) throws Exception{
        initializeForReaḍ̣̣̣̣̣();
        Sheet sheet = getSheetWithName(className);
        Class cls = Class.forName(workbook.getSheetName(0));
        setupFileForClass(cls);
        List<T> result = new ArrayList<T>();
        Row row;
        for(int i=0; i<5; i++){
            T one = (T) cls.newInstance();
            row=sheet.getRow(i);
            int colcount = 0;
            result.add(one);
            for(Cell cell:row){
                String fileName =fileNames.get(colcount ++);
                Method method = constructMethod(cls,fileName);
                CellType cellType =cell.getCellTypeEnum();
                if(cellType == CellType.STRING){
                    String value = cell.getStringCellValue();
                    Object[] values = new Object[1];
                    values[0] = value;
                    method.invoke(one,values);
                }
                else if (cellType == CellType.NUMERIC){
                    Double num = cell.getNumericCellValue();
                    Class<?> returnType = getGetterReturnClass(cls,fileName);
                    if(returnType==int.class || returnType == Integer.class){
                        method.invoke(one,num.intValue());
                    }else if (returnType==double.class || returnType == Double.class){
                        method.invoke(one,num.doubleValue());
                    }else if (returnType == long.class || returnType == Long.class){
                        method.invoke(one,num.longValue());
                    }else if (returnType == Date.class){
                        Date date = cell.getDateCellValue();
                        method.invoke(one,date);
                    }
                }
                else if ( cellType == CellType.BOOLEAN ){
                    Boolean num = cell.getBooleanCellValue();
                    Object[] values = new Object[1];
                    values[0] = num;
                    method.invoke(one,values);
                }
            }
        }
        return result;
    }

    public void removeFile(String filepath){
        File file = new File(filepath);
        if(file.exists() && file.canWrite()){
            file.delete();
        }
    }

    public List<String> getFileNames() {
        return fileNames;
    }

    public void setFileNames(List<String> fileNames) {
        this.fileNames = fileNames;
    }

    public Workbook getWorkbook() {
        return workbook;
    }

    public void setWorkbook(Workbook workbook) {
        this.workbook = workbook;
    }

    public String getWorkBookName() {
        return workBookName;
    }

    public void setWorkBookName(String workBookName) {
        this.workBookName = workBookName;
    }
}
