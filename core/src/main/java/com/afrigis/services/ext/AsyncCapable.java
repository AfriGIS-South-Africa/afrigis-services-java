package com.afrigis.services.ext;

import java.util.concurrent.ExecutorService;

/**
 * Interface for services that will be providing async calls. The main goal is
 * to be able to pass a common thread pool around easily and consistently.
 * 
 * @author hendrikc
 *
 */
public interface AsyncCapable {

    /**
     * <p>
     * Method by which an implementor receives functional
     * {@link ExecutorService}.
     * </p>
     * 
     * @param execService
     *            a working {@link ExecutorService}
     */
    void setExecService(ExecutorService execService);

}
