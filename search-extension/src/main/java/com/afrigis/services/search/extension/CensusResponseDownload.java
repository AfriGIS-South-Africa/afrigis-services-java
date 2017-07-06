/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afrigis.services.search.extension;

import com.afrigis.services.Response;

/**
 *
 * @author Takalani
 */
public interface CensusResponseDownload extends Response {

    @Override
    public byte[] getByteArray();
}
