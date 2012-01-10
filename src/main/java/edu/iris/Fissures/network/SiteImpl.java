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
import edu.iris.Fissures.TimeRange;
import edu.iris.Fissures.IfNetwork.Site;
import edu.iris.Fissures.IfNetwork.SiteId;
import edu.iris.Fissures.IfNetwork.Station;

//
// IDL:iris.edu/Fissures/IfNetwork/Site:1.0
//
/***/

public class SiteImpl extends Site
{

	protected SiteImpl() {
    }

    public static SiteImpl createEmpty() {
    return new SiteImpl();
    }

    public SiteImpl(SiteId id,
                    Location my_location,
                    TimeRange effective_time,
                    Station my_station,
                    String comment) {
        this.id = id;
        this.my_location = my_location;
        this.effective_time = effective_time;
        this.setStation(my_station);
        this.comment = comment;
    }

    /** Constructs a Site with begin effective time extracted from
    the siteId and no known end time, ie still operational. */
    public SiteImpl(SiteId id,
                    Location my_location,
                    Station my_station,
                    String comment) {
        this(id,
         my_location,
         new TimeRange(id.begin_time,
               edu.iris.Fissures.model.TimeUtils.timeUnknown),
         my_station,
         comment);
    }

    /** Constructs a Site with begin effective time extracted from
    the siteId and no known end time, ie still operational, and location from the station. */
    public SiteImpl(SiteId id,
                    Station my_station,
                    String comment) {
        this(id,
         my_station.getLocation(),
         new TimeRange(id.begin_time,
               edu.iris.Fissures.model.TimeUtils.timeUnknown),
         my_station,
         comment);
    }

    //
    // IDL:iris.edu/Fissures/IfNetwork/Site/get_id:1.0
    //
    public SiteId
    get_id()
    {
        return getId();
    }

    //
    // IDL:iris.edu/Fissures/IfNetwork/Site/get_code:1.0
    //
    public String
    get_code()
    {
        return getId().site_code;
    }
}
