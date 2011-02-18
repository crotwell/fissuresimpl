package edu.iris.Fissures.seismogramDC;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import junit.framework.TestCase;
import edu.iris.Fissures.FissuresException;
import edu.iris.Fissures.IfNetwork.ChannelId;
import edu.iris.Fissures.IfNetwork.NetworkId;
import edu.iris.Fissures.IfParameterMgr.ParameterRef;
import edu.iris.Fissures.IfSeismogramDC.Property;
import edu.iris.Fissures.IfTimeSeries.EncodedData;
import edu.iris.Fissures.IfTimeSeries.TimeSeriesDataSel;
import edu.iris.Fissures.model.SamplingImpl;
import edu.iris.Fissures.model.TimeInterval;
import edu.iris.Fissures.model.UnitImpl;

/**
* Generated by JUnitDoclet, a tool provided by
* ObjectFab GmbH under LGPL.
* Please see www.junitdoclet.org, www.gnu.org
* and www.objectfab.de for informations about
* the tool, the licence and the authors.
*/


public class LocalSeismogramImplTest
// JUnitDoclet begin extends_implements
    extends TestCase
        // JUnitDoclet end extends_implements
{
    // JUnitDoclet begin class
    edu.iris.Fissures.seismogramDC.LocalSeismogramImpl localseismogramimpl = null;
    byte[] dataBits = new byte[99];
    int bytesPerSample = 3;

    // JUnitDoclet end class

    public LocalSeismogramImplTest(String name) {
    // JUnitDoclet begin method LocalSeismogramImplTest
    super(name);
    // JUnitDoclet end method LocalSeismogramImplTest
    }

    public edu.iris.Fissures.seismogramDC.LocalSeismogramImpl createInstance() throws Exception {
    // JUnitDoclet begin method testcase.createInstance
    String name = "Test";

    // generate bytesPerSample data as all 1
    for ( int i=0; i<dataBits.length; i++) {
        if ( i % bytesPerSample == bytesPerSample-1 ) {
        dataBits[i] = 1;
        } // end of if ()
    } // end of for ()
        TimeSeriesDataSel bits = new TimeSeriesDataSel();
    EncodedData[] edata = new EncodedData[1];
    edata[0] = new EncodedData((short)edu.iris.dmc.seedcodec.B1000Types.INT24,
                  dataBits,
                   dataBits.length / bytesPerSample,
                   false);
        bits.encoded_values(edata);


        edu.iris.Fissures.Time time =
        new edu.iris.Fissures.Time("19991231T235959.000Z",
                       -1);
        String id = "Nowhere: "+name;
    TimeInterval timeInterval = new TimeInterval(1, UnitImpl.SECOND);
        SamplingImpl sampling =
            new SamplingImpl(20,
                 timeInterval);
        ChannelId channelID = new ChannelId(new NetworkId("XX",
                              time),
                        "FAKE",
                        "00",
                        "BHZ",
                                            time);


        Property[] props = new Property[1];
        props[0] = new Property("Name", name);
    TimeInterval[] time_corr = new TimeInterval[1];
    time_corr[0] = new TimeInterval(.123, UnitImpl.SECOND);
        LocalSeismogramImpl seis =
        new LocalSeismogramImpl(id,
                    props,
                    time,
                    dataBits.length / bytesPerSample,
                    sampling,
                    UnitImpl.COUNT,
                    channelID,
                    new ParameterRef[0],
                    time_corr,
                    new SamplingImpl[0],
                    bits);
        return seis;
    // JUnitDoclet end method testcase.createInstance
    }

    protected void setUp() throws Exception {
    // JUnitDoclet begin method testcase.setUp
    super.setUp();
    localseismogramimpl = createInstance();
    // JUnitDoclet end method testcase.setUp
    }

    protected void tearDown() throws Exception {
    // JUnitDoclet begin method testcase.tearDown
    localseismogramimpl = null;
    super.tearDown();
    // JUnitDoclet end method testcase.tearDown
    }

    public void testGetNumPoints() throws Exception {
    // JUnitDoclet begin method getNumPoints
    assertEquals(dataBits.length/bytesPerSample,
             localseismogramimpl.getNumPoints());
    // JUnitDoclet end method getNumPoints
    }

    public void testSerialize() throws Exception {
        File tmp = File.createTempFile("seis", "_tmp");
        ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(tmp)));
        out.writeObject( localseismogramimpl);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(tmp)));
        LocalSeismogramImpl inSeis = (LocalSeismogramImpl)in.readObject();
        tmp.delete();
        assertEquals(localseismogramimpl.get_as_longs()[0], inSeis.get_as_longs()[0]);
    }

    public void testGetMaxValue() throws Exception {
    // JUnitDoclet begin method getMaxValue
    // JUnitDoclet end method getMaxValue
    }

    public void testGetMeanValue() throws Exception {
    // JUnitDoclet begin method getMeanValue
    // JUnitDoclet end method getMeanValue
    }

    public void testGetValueAt() throws Exception {
    // JUnitDoclet begin method getValueAt
    // JUnitDoclet end method getValueAt
    }

    public void testGetAmplitudeRange() throws Exception {
    // JUnitDoclet begin method getAmplitudeRange
    // JUnitDoclet end method getAmplitudeRange
    }

    public void testIs_long() throws Exception {
    // JUnitDoclet begin method is_long
    assertFalse(localseismogramimpl.is_long());
    // JUnitDoclet end method is_long
    }

    public void testIs_float() throws Exception {
    // JUnitDoclet begin method is_float
    assertFalse(localseismogramimpl.is_float());
    // JUnitDoclet end method is_float
    }

    public void testIs_double() throws Exception {
    // JUnitDoclet begin method is_double
    assertFalse(localseismogramimpl.is_double());
    // JUnitDoclet end method is_double
    }

    public void testIs_short() throws Exception {
    // JUnitDoclet begin method is_short
    assertFalse(localseismogramimpl.is_short());
    // JUnitDoclet end method is_short
    }

    public void testIs_encoded() throws Exception {
    // JUnitDoclet begin method is_encoded
    assertTrue(localseismogramimpl.is_encoded());
    // JUnitDoclet end method is_encoded
    }

    public void testCan_convert_to_long() throws Exception {
    // JUnitDoclet begin method can_convert_to_long
    assertTrue(localseismogramimpl.can_convert_to_long());
    // JUnitDoclet end method can_convert_to_long
    }

    public void testCan_convert_to_float() throws Exception {
    // JUnitDoclet begin method can_convert_to_float
    assertTrue(localseismogramimpl.can_convert_to_float());
    // JUnitDoclet end method can_convert_to_float
    }

    public void testCan_convert_to_double() throws Exception {
    // JUnitDoclet begin method can_convert_to_double
    assertTrue(localseismogramimpl.can_convert_to_double());
    // JUnitDoclet end method can_convert_to_double
    }

    public void testCan_convert_to_short() throws Exception {
    // JUnitDoclet begin method can_convert_to_short
    assertFalse(localseismogramimpl.can_convert_to_short());
    // JUnitDoclet end method can_convert_to_short
    }

    public void testGet_as_longs() throws Exception {
    // JUnitDoclet begin method get_as_longs
    int[] out = localseismogramimpl.get_as_longs();
    assertNotNull("get as longs returned null", out);
    assertEquals("length of get_as_longs and getNumPoints not the same."
             +out.length+" "+localseismogramimpl.getNumPoints(),
             out.length,
             localseismogramimpl.getNumPoints());
    // JUnitDoclet end method get_as_longs
    }

    public void testGet_as_shorts() throws Exception {
    // JUnitDoclet begin method get_as_shorts
        try {
    short[] out = localseismogramimpl.get_as_shorts();
            assertTrue("want the exception to throw, so should never get here",false);
        } catch(FissuresException e) {}
    // JUnitDoclet end method get_as_shorts
    }

    public void testGet_as_floats() throws Exception {
    // JUnitDoclet begin method get_as_floats
    float[] out = localseismogramimpl.get_as_floats();
    assertNotNull("get as floats returned null", out);
    assertEquals("length of get_as_floats and getNumPoints not the same."
             +out.length+" "+localseismogramimpl.getNumPoints(),
             out.length,
             localseismogramimpl.getNumPoints());
    // JUnitDoclet end method get_as_floats
    }

    public void testGet_as_doubles() throws Exception {
    // JUnitDoclet begin method get_as_doubles
    double[] out = localseismogramimpl.get_as_doubles();
    assertNotNull("get as doubles returned null", out);
    assertEquals("length of get_as_doubles and getNumPoints not the same."
             +out.length+" "+localseismogramimpl.getNumPoints(),
             out.length,
             localseismogramimpl.getNumPoints());
    // JUnitDoclet end method get_as_doubles
    }

    public void testGet_as_encoded() throws Exception {
    // JUnitDoclet begin method get_as_encoded
    EncodedData[] out = localseismogramimpl.get_as_encoded();
    // JUnitDoclet end method get_as_encoded
    }

    public void testClose() throws Exception {
    // JUnitDoclet begin method close
    // JUnitDoclet end method close
    }

    public void testGet_audit_trail() throws Exception {
    // JUnitDoclet begin method get_audit_trail
    // JUnitDoclet end method get_audit_trail
    }

    public void testAppend_longs() throws Exception {
    // JUnitDoclet begin method append_longs
    // JUnitDoclet end method append_longs
    }

    public void testAppend_shorts() throws Exception {
    // JUnitDoclet begin method append_shorts
    // JUnitDoclet end method append_shorts
    }

    public void testAppend_floats() throws Exception {
    // JUnitDoclet begin method append_floats
    // JUnitDoclet end method append_floats
    }

    public void testAppend_doubles() throws Exception {
    // JUnitDoclet begin method append_doubles
    // JUnitDoclet end method append_doubles
    }

    public void testAppend_encoded_seq() throws Exception {
    // JUnitDoclet begin method append_encoded_seq
    // JUnitDoclet end method append_encoded_seq
    }

    public void testAppend_encoded() throws Exception {
    // JUnitDoclet begin method append_encoded
    // JUnitDoclet end method append_encoded
    }

    public void testCalculateNumPoints() throws Exception {
    // JUnitDoclet begin method calculateNumPoints
    // JUnitDoclet end method calculateNumPoints
    }

    public void testGetValues() throws Exception {
    // JUnitDoclet begin method getValues
    // JUnitDoclet end method getValues
    }

    public void testGetDataType() throws Exception {
    // JUnitDoclet begin method getDataType
    // JUnitDoclet end method getDataType
    }

    public void testAppend() throws Exception {
    // JUnitDoclet begin method append
    // JUnitDoclet end method append
    }

    public void testDataChanged() throws Exception {
    // JUnitDoclet begin method dataChanged
    // JUnitDoclet end method dataChanged
    }



    /**
     * JUnitDoclet moves marker to this method, if there is not match
     * for them in the regenerated code and if the marker is not empty.
     * This way, no test gets lost when regenerating after renaming.
     * Method testVault is supposed to be empty.
     */
    public void testVault() throws Exception {
    // JUnitDoclet begin method testcase.testVault
    // JUnitDoclet end method testcase.testVault
    }

    public static void main(String[] args) {
    // JUnitDoclet begin method testcase.main
    junit.textui.TestRunner.run(LocalSeismogramImplTest.class);
    // JUnitDoclet end method testcase.main
    }
}
