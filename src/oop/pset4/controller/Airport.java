package oop.pset4.controller;

import oop.pset4.controller.travelstage.*;
import oop.pset4.model.Luggage;
import oop.pset4.view.SummaryReporter;

import java.util.List;
import java.util.stream.Collectors;

public class Airport {

    private SecurityControl securityControl = new SecurityControl();

    private TravelStage dropOff = new DropOffStand();
    private TravelStage storageArea = new StorageArea();
    private TravelStage transportCart = new TransportCart();
    private TravelStage flight = new Flight();
    private TravelStage luggageClaim = new LuggageClaim();

    private SummaryReporter summaryReporter = new SummaryReporter();

    public List<Luggage> travel(List<Luggage> departureLuggage) {
        // TODO apply airport travel stages per the following order

        // show a welcome message
        summaryReporter.showHeader();


        // allow passengers to travel only if they show up at least 30 mins before departure time
        // drop the luggage at the drop off stand
        // bring the luggage to the storage area
        // carry the luggage to the plane with the transport cart
        // flight to the destination
        // carry the luggage to the luggage claim with the transport cart
        // pick up the luggage from the luggage claim

        List<Luggage> acceptedLuggage = departureLuggage.stream()
                .filter( luggage -> securityControl.isAllowedToTravel( luggage ) )
                .map( luggage -> dropOff.process( luggage ) )
                .map( luggage -> storageArea.process( luggage ) )
                .map( luggage -> transportCart.process( luggage ) )
                .map( luggage -> flight.process( luggage ) )
                .map( luggage -> transportCart.process( luggage ) )
                .map( luggage -> luggageClaim.process( luggage ) )
                .collect( Collectors.toList() );



        // display luggage report summary for rejected luggage

        List<Luggage> rejectedLuggage = securityControl.getRejectedLuggage();
        summaryReporter.reportRejected( rejectedLuggage );

        // display luggage report summary for accepted luggage
        summaryReporter.reportAccepted( acceptedLuggage );

        return acceptedLuggage;
    }


}
