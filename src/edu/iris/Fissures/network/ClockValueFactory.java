// **********************************************************************
//
// Generated by the ORBacus IDL to Java Translator
//
// Copyright (c) 2000
// Object Oriented Concepts, Inc.
// Billerica, MA, USA
//
// All Rights Reserved
//
// **********************************************************************

// Version: 4.0.3

package edu.iris.Fissures.network;

import edu.iris.Fissures.IfNetwork.Clock;

//
// IDL:iris.edu/Fissures/IfNetwork/Clock:1.0
//
/***/

public class ClockValueFactory implements org.omg.CORBA.portable.ValueFactory
{
    public java.io.Serializable
    read_value(org.omg.CORBA_2_3.portable.InputStream in)
    {
        // TODO: implement
        Clock result = ClockImpl.createEmpty();
        return in.read_value(result);
    }
}
