package com.kat.lap_trinh_web.rewrite;

import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.rule.Join;

import javax.servlet.ServletContext;

@RewriteConfiguration
public class KatRewriteConfiguration extends HttpConfigurationProvider {

    @Override
    public int priority()
    {
        return 10;
    }


    @Override
    public Configuration getConfiguration(final ServletContext context)
    {
        return ConfigurationBuilder.begin()
//                .addRule().perform(Log.message(Level.INFO, "Rewrite is active :D."))
                .addRule(Join.path("/").to("/index.xhtml").withInboundCorrection())
                .addRule(Join.path("/error").to("/pages/error.xhtml").withInboundCorrection())
                .addRule(Join.path("/config").to("/pages/admin/config.xhtml").withInboundCorrection())
                .addRule(Join.path("/login").to("/pages/admin/login.xhtml").withInboundCorrection())
                .addRule(Join.path("/logout").to("/pages/admin/logout.xhtml").withInboundCorrection())
                .addRule(Join.path("/main").to("/pages/tools/dash.xhtml").withInboundCorrection())
                .addRule(Join.path("/test").to("/testExcel.xhtml").withInboundCorrection())
                .addRule(Join.path("/api/testExcel").to("/pages/admin/testExcel.xhtml").withInboundCorrection())
                .addRule(Join.path("/student").to("/pages/admin/Student.xhtml").withInboundCorrection())
                .addRule(Join.path("/import").to("/pages/admin/import.xhtml").withInboundCorrection())
                .addRule(Join.path("/student_add").to("/pages/admin/studentAdd.xhtml").withInboundCorrection())
                .addRule(Join.path("/student_edit").to("/pages/admin/studentEdit.xhtml").withInboundCorrection())
                .addRule(Join.path("/lecturers_edit").to("/pages/admin/lecturersEdit.xhtml").withInboundCorrection())
                .addRule(Join.path("/lecturers").to("/pages/admin/lecturers.xhtml").withInboundCorrection())
                .addRule(Join.path("/lecturers_add").to("/pages/admin/lecturersAdd.xhtml").withInboundCorrection())
                .addRule(Join.path("/all_Servey").to("/pages/admin/all_Servey.xhtml").withInboundCorrection())
                ;
    }
}
