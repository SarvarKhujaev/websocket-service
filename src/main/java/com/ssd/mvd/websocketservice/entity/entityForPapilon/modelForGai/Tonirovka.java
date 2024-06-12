package com.ssd.mvd.websocketservice.entity.entityForPapilon.modelForGai;

import com.ssd.mvd.websocketservice.constants.ErrorResponse;

public final class Tonirovka {
    private String DateBegin;
    private String DateValid;
    private String TintinType;
    private String dateOfPermission;
    private String dateOfValidotion; // дата валидности разрешения, в случае если он просрочен пометить красным
    private String permissionLicense;
    private String whoGavePermission;
    private String organWhichGavePermission;

    private ErrorResponse errorResponse;
}
