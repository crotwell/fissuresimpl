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

import edu.iris.Fissures.Location;
import edu.iris.Fissures.Time;
import edu.iris.Fissures.TimeRange;
import edu.iris.Fissures.IfNetwork.NetworkAttr;
import edu.iris.Fissures.IfNetwork.Station;
import edu.iris.Fissures.IfNetwork.StationId;
import edu.iris.Fissures.model.TimeUtils;

//
// IDL:iris.edu/Fissures/IfNetwork/Station:1.0
//
/***/

public class StationImpl extends Station
{

    protected StationImpl() {
    }

    public static StationImpl createEmpty() {
    return new StationImpl();
    }

    public StationImpl(StationId id,
                       String name,
                       Location my_location,
                       TimeRange effective_time,
                       String operator,
                       String description,
                       String comment,
                       NetworkAttr my_network) {
        this.id = id;
        this.name = name;
        this.setLocation(my_location);
        this.setEffectiveTime(effective_time);
        this.operator = operator;
        this.description = description;
        this.comment = comment;
        this.setNetworkAttr(my_network);
    }

    /** creates a StationImpl where the begin effective time is
     *  extracted from the StationId and the end is unknown, ie
     *  still operational. */
    public StationImpl(StationId id,
                       String name,
                       Location my_location,
                       String operator,
                       String description,
                       String comment,
                       NetworkAttr my_network) {
        this(id,
         name,
         my_location,
         new TimeRange(id.begin_time,
               edu.iris.Fissures.model.TimeUtils.timeUnknown),
         operator,
         description,
         comment,
         my_network);
    }
    //
    // IDL:iris.edu/Fissures/IfNetwork/Station/get_id:1.0
    //
    public StationId
    get_id()
    {
        return getId();
    }

    //
    // IDL:iris.edu/Fissures/IfNetwork/Station/get_code:1.0
    //
    public String
    get_code()
    {
        return getId().station_code;
    }
    
    // hibernate

    
    protected int dbid;
    protected void setDbid(int dbid) {
        this.dbid = dbid;
    }
    public int getDbid() {
        return dbid;
    }

    public void associateInDB(StationImpl indb) {
        setDbid(indb.getDbid());
    }
}
