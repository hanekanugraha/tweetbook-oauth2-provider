/*
 * $Id: LicenseManager.java 10480 2007-12-19 00:47:04Z moosa $
 * --------------------------------------------------------------------------------------
 * (c) 2003-2008 MuleSource, Inc. This software is protected under international copyright
 * law. All use of this software is subject to MuleSource's Master Subscription Agreement
 * (or other master license agreement) separately entered into in writing between you and
 * MuleSource. If such an agreement is not in place, you may not use the software.
 */

package org.mule.security.examples.oauth2;

import java.util.Collections;
import java.util.Map;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.mule.module.spring.security.SpringAuthenticationAdapter;

/**
 * Returns the profile information from the authenticated user
 */
public class ProfileLookupComponent implements Callable
{
    private static Map<String, String> USER_PROFILES = Collections.singletonMap("john", "John Q. Doe");

    public Object onCall(final MuleEventContext eventContext) throws Exception
    {
        final String userName = ((SpringAuthenticationAdapter) eventContext.getSession()
            .getSecurityContext()
            .getAuthentication()).getName();
        return USER_PROFILES.get(userName);
    }
}
