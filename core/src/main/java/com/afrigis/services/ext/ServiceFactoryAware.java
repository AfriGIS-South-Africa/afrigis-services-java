package com.afrigis.services.ext;

import com.afrigis.services.ServiceCallFactory;

/**
 * <p>
 * Interface for service implementing classes that which to receive a reference
 * to the factory object that instantiated them.
 * </p>
 * 
 * @author hendrikc
 *
 * @see ServiceCallFactory
 */
public interface ServiceFactoryAware {

    /**
     * Receives the {@link ServiceCallFactory} that created this instance.
     * 
     * @param factory
     *            a reference to the factory that created this object
     */
    void setServiceFactory(ServiceCallFactory factory);
}
