package com.kat.lap_trinh_web.service.interfaces;

import com.kat.lap_trinh_web.common.model.LoggedUser;

public interface AuthorityService {
    LoggedUser validateUser(String username, String password);
}
