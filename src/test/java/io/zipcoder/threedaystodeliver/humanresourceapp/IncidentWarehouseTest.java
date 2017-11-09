/*
package io.zipcoder.threedaystodeliver.humanresourceapp;

import com.sun.tools.corba.se.idl.IncludeEntry;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IncidentWarehouseTest {

    IncidentReportWarehouse incidentReportWarehouse;

    @Before
    public void setup(){ incidentReportWarehouse = IncidentReportWarehouse.getInstance();}


    @Test
    public void addIncidentReportTest(){

        int expected = incidentReportWarehouse.getAllIncidents().size();

        IncidentReport incident1 = new IncidentReport();
        IncidentReport incident2 = new IncidentReport();
        IncidentReport incident3 = new IncidentReport();
        IncidentReport poorFluffy = new IncidentReport();

        incidentReportWarehouse.addIncident(poorFluffy);
        incidentReportWarehouse.addIncident(incident1);
        incidentReportWarehouse.addIncident(incident2);
        incidentReportWarehouse.addIncident(incident3);

        int actual = incidentReportWarehouse.getAllIncidents().size();

        Assert.assertEquals(expected+4 , actual);
    }

    @Test
    public void getAllIncidentsTest(){

        int expected = incidentReportWarehouse.getAllIncidents().size();

        for(int i=0; i < 321; i++){
            IncidentReport incident = new IncidentReport();
            incidentReportWarehouse.addIncident(incident);
        }

        int actual = incidentReportWarehouse.getAllIncidents().size();

        Assert.assertEquals(expected+321,actual);


    }

    }


*/
