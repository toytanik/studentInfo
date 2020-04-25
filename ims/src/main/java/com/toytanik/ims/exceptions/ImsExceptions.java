package com.toytanik.ims.exceptions;

import com.toytanik.ims.ImsErrorCode;

public class ImsExceptions extends Exception{
    public ImsExceptions(ImsErrorCode imsErrorCode) {
        super(String.valueOf(imsErrorCode));
    }
}
