package api;

import api.Role.AirCaptain;
import api.Role.AirlineComManager;
import api.Role.AirportControl;
import api.Role.Customer;
import api.Role.CustomerService;
import api.Role.RailwayComManager;
import api.Role.StationControl;
import api.Role.TrainCaptain;
import api.Role.VIPCustomer;
import api.Role.VIPCustomerService;
import api.employee.Employee;
import api.Role.sysAdmin;
import api.employee.EmployeeDirectory;
import api.enterprise.Enterprise;
import api.enterprise.EnterpriseDirectory;
import api.organization.AirlineCompany;
import api.organization.Airport;
import api.organization.OrganizationDirectory;
import api.organization.RailwayCompany;
import api.organization.Station;
import api.property.Airplane;
import api.property.Enter;
import api.property.Gate;
import api.property.Road;
import api.property.Train;
import api.request.Flight;
import api.request.Landing;
import api.request.TrainLine;
import api.request.requestDirectory;
import api.userAccount.UserAccount;
import api.userAccount.UserAccountDirectory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rrheg
 */
public class ConfigureASystem {
    
    public static TravelSystem configure() throws ParseException{
        TravelSystem system = TravelSystem.getInstance();
            
            //Create a network
            //create an enterprise
            //initialize some organizations
            //have some employees
            //create user account
            
            Airplane airplane1 = new Airplane("N01" ,"A100", 2020,1,10, 0, 0, 10);
            Airplane airplane2 = new Airplane("N02" ,"A100", 2019,2,10,0, 0, 10);
            Airplane airplane3 = new Airplane("N03" ,"A200", 2018,3,82,60, 18, 4);
            Airplane airplane4 = new Airplane("N04" ,"A200", 2017,4,82,60, 18, 4);
            Airplane airplane5 = new Airplane("N05" ,"A300", 2020,1,134,90, 36, 8);
            Airplane airplane6 = new Airplane("N06" ,"A300", 2019,2,134, 90, 36, 8);
            ArrayList<Airplane> NairplaneList = new ArrayList<Airplane>();
            NairplaneList.add(airplane1);
            NairplaneList.add(airplane2);
            NairplaneList.add(airplane3);
            NairplaneList.add(airplane4);
            NairplaneList.add(airplane5);
            NairplaneList.add(airplane6);
             Airplane airplane11 = new Airplane("E01" ,"A100", 2020,1,10,0, 0, 10);
            Airplane airplane22 = new Airplane("E02" ,"A200", 2020,1,82,60, 18, 4);
            Airplane airplane33 = new Airplane("E03" ,"A200", 2019,2,82,60, 18, 4);
            Airplane airplane44 = new Airplane("E04" ,"A200", 2018,3,82,60, 18, 4);
            Airplane airplane55 = new Airplane("E05" ,"A300", 2018,3,134,90, 36, 8);
            Airplane airplane66 = new Airplane("E06" ,"A300", 2017 ,4,134,90, 36, 8);
            ArrayList<Airplane> EairplaneList = new ArrayList<Airplane>();
            EairplaneList.add(airplane11);
            EairplaneList.add(airplane22);
            EairplaneList.add(airplane33);
            EairplaneList.add(airplane44);
            EairplaneList.add(airplane55);
            EairplaneList.add(airplane66);
            
            
            
            Enter enter1 = new Enter(1,"Available");
            Enter enter2 = new Enter(2,"Available");
            Enter enter3 = new Enter(3,"Available");
            Enter enter4 = new Enter(4,"Available");
            Enter enter5 = new Enter(5,"Available");
            Enter enter6 = new Enter(6,"Available");
            ArrayList<Enter> EnterList1 = new ArrayList<Enter>();
            ArrayList<Enter> EnterList2 = new ArrayList<Enter>();
            ArrayList<Enter> EnterList3 = new ArrayList<Enter>();
            EnterList1.add(enter1);
            EnterList1.add(enter2);
            EnterList1.add(enter3);
            EnterList1.add(enter4);
            EnterList1.add(enter5);
            EnterList1.add(enter6);
            Enter enter11 = new Enter(1,"Available");
            Enter enter22 = new Enter(2,"Available");
            Enter enter33 = new Enter(3,"Available");
            Enter enter44 = new Enter(4,"Available");
            Enter enter55 = new Enter(5,"Available");
            EnterList2.add(enter11);
            EnterList2.add(enter22);
            EnterList2.add(enter33);
            EnterList2.add(enter44);
            EnterList2.add(enter55);
            Enter enter111 = new Enter(1,"Available");
            Enter enter222 = new Enter(2,"Available");
            Enter enter333 = new Enter(3,"Available");
            Enter enter444 = new Enter(4,"Available");
            EnterList3.add(enter111);
            EnterList3.add(enter222);
            EnterList3.add(enter333);
            EnterList3.add(enter444);
            
            Gate gate1 = new Gate(1,"Available");
            Gate gate2 = new Gate(2,"Available");
            Gate gate3 = new Gate(3,"Available");
            Gate gate4 = new Gate(4,"Available");
            Gate gate5 = new Gate(5,"Available");
            Gate gate6 = new Gate(6,"Available");
            ArrayList<Gate> GateList1 = new ArrayList<Gate>();
            ArrayList<Gate> GateList2 = new ArrayList<Gate>();
            ArrayList<Gate> GateList3 = new ArrayList<Gate>();
            GateList1.add(gate1);
            GateList1.add(gate2);
            GateList1.add(gate3);
            GateList1.add(gate4);
            GateList1.add(gate5);
            GateList1.add(gate6);
            Gate gate11 = new Gate(1,"Available");
            Gate gate22 = new Gate(2,"Available");
            Gate gate33 = new Gate(3,"Available");
            Gate gate44 = new Gate(4,"Available");
            Gate gate55 = new Gate(5,"Available");
            Gate gate111 = new Gate(1,"Available");
            Gate gate222 = new Gate(2,"Available");
            Gate gate333 = new Gate(3,"Available");
            Gate gate444 = new Gate(4,"Available");
            GateList2.add(gate11);
            GateList2.add(gate22);
            GateList2.add(gate33);
            GateList2.add(gate44);
            GateList2.add(gate55);
            GateList3.add(gate111);
            GateList3.add(gate222);
            GateList3.add(gate333);
            GateList3.add(gate444);
            
            Road road1 = new Road(1,"Available");
            Road road2 = new Road(2,"Available");
            Road road3 = new Road(3,"Available");
            Road road4 = new Road(4,"Available");
            Road road5 = new Road(5,"Available");
            Road road6 = new Road(6,"Available");
            ArrayList<Road> road1List1 = new ArrayList<Road>();
            ArrayList<Road> road1List2 = new ArrayList<Road>();
            ArrayList<Road> road1List3 = new ArrayList<Road>();
            road1List1.add(road1);
            road1List1.add(road2);
            road1List1.add(road3);
            road1List1.add(road4);
            road1List1.add(road5);
            road1List1.add(road6);
            Road road11 = new Road(1,"Available");
            Road road22 = new Road(2,"Available");
            Road road33 = new Road(3,"Available");
            Road road44 = new Road(4,"Available");
            Road road55 = new Road(5,"Available");
            Road road111 = new Road(1,"Available");
            Road road222 = new Road(2,"Available");
            Road road333 = new Road(3,"Available");
            Road road444 = new Road(4,"Available");
            road1List2.add(road11);
            road1List2.add(road22);
            road1List2.add(road33);
            road1List2.add(road44);
            road1List2.add(road55);
            road1List3.add(road111);
            road1List3.add(road222);
            road1List3.add(road333);
            road1List3.add(road444);
            
            
            
            Train train1 = new Train("NT01", "T800", 2020, 1,20, 0, 0, 0, 20, 2);
            Train train2 = new Train("NT02", "T100", 2019, 2,350,200, 100, 40, 10, 1);
            Train train3 = new Train("NT03", "T100", 2019, 2,350,200, 100, 40, 10, 1);
            ArrayList<Train> TrainList1 = new ArrayList<Train>();
            ArrayList<Train> TrainList2 = new ArrayList<Train>();
            TrainList1.add(train1);
            TrainList1.add(train2);
            TrainList1.add(train3);
            Train train11 = new Train("ET01", "T800",2018,3,20, 0, 0, 0, 20, 2);
            Train train22 = new Train("ET02", "T800",2020,1,20, 0, 0, 0, 20, 2);
            Train train33 = new Train("ET03", "T100",2019,2,350, 200, 100, 40, 10, 1);
            TrainList2.add(train11);
            TrainList2.add(train22);
            TrainList2.add(train33);
            
            Employee airportControl1 = new Employee("NController1", 1, "NController1", "NController1", 1000, new AirportControl());
            Employee airportControl2 = new Employee("NController2", 2, "NController2", "NController2", 900, new AirportControl());
            ArrayList<Employee> EmployeeList1 = new ArrayList<Employee>();
            
            Employee airportControl11 = new Employee("BController1", 1, "BController1", "BController1", 1000, new AirportControl());
            Employee airportControl22 = new Employee("BController2", 2, "BController2", "BController2", 900, new AirportControl());
            ArrayList<Employee> EmployeeList2 = new ArrayList<Employee>();
            
            Employee airportControl111 = new Employee("DController1", 1, "DController1", "DController1", 1000, new AirportControl());
            Employee airportControl222 = new Employee("DController2", 2, "DController2", "DController2", 900, new AirportControl());
            ArrayList<Employee> EmployeeList3 = new ArrayList<Employee>();
            EmployeeList1.add(airportControl1);
            EmployeeList1.add(airportControl2);
            EmployeeList2.add(airportControl11);
            EmployeeList2.add(airportControl22);
            EmployeeList3.add(airportControl111);
            EmployeeList3.add(airportControl222);
            EmployeeDirectory e1 = new EmployeeDirectory(EmployeeList1);
            EmployeeDirectory e2 = new EmployeeDirectory(EmployeeList2);
            EmployeeDirectory e3 = new EmployeeDirectory(EmployeeList3);
            
            Employee airlineMan1 = new Employee("NAirlineManager1", 1, "NAirlineManager1", "NAirlineManager1", 10000, new AirlineComManager());
            Employee airlineMan2 = new Employee("EAirlineManager1", 1, "EAirlineManager1", "EAirlineManager1", 10000, new AirlineComManager());
            
            Employee Service1 = new Employee("NService1", 2, "NService1", "NService1", 500, new CustomerService());
            Employee Service2 = new Employee("EService1", 2, "EService1", "EService1", 500, new CustomerService());
            
            Employee vService1 = new Employee("NVIPService1", 3, "NVService1", "NVService1", 1500, new VIPCustomerService());
            Employee vService2 = new Employee("EVIPService1", 3, "EVService1", "EVService1", 1500, new VIPCustomerService());
            
             Employee AirCaptain1 = new Employee("EAirCaptain1", 4, "EAirCaptain1", "EAirCaptain1", 15000, new AirCaptain());
            Employee AirCaptain2 = new Employee("EAirCaptain2", 5, "EAirCaptain2", "EAirCaptain2", 15000, new AirCaptain());
            Employee AirCaptain11 = new Employee("NAirCaptain1", 4, "NAirCaptain1", "NAirCaptain1", 15000, new AirCaptain());
            Employee AirCaptain22 = new Employee("NAirCaptain2", 5, "NAirCaptain2", "NAirCaptain2", 15000, new AirCaptain());
            
            
            ArrayList<Employee> EmployeeList4 = new ArrayList<Employee>();
            EmployeeList4.add(airlineMan1);
            EmployeeList4.add(Service1);
            EmployeeList4.add(vService1);
            EmployeeList4.add(AirCaptain11);
            EmployeeList4.add(AirCaptain22);
            
            
            ArrayList<Employee> EmployeeList5 = new ArrayList<Employee>();
            EmployeeList5.add(airlineMan2);
            EmployeeList5.add(Service2);
            EmployeeList5.add(vService2);
            EmployeeList5.add(AirCaptain1);
            EmployeeList5.add(AirCaptain2);
            
            EmployeeDirectory e4 = new EmployeeDirectory(EmployeeList4);
            EmployeeDirectory e5 = new EmployeeDirectory(EmployeeList5);
            
            
            Employee stationControl1 = new Employee("NSController1", 1, "NSController1", "NSController1", 1200, new StationControl());
            Employee stationControl2 = new Employee("NSController2", 2, "NSController2", "NSController2", 1000, new StationControl());
            ArrayList<Employee> EmployeeList6 = new ArrayList<Employee>();
            
            Employee stationControl11 = new Employee("BSController1", 1, "BSController1", "BSController1", 1000, new StationControl());
            Employee stationControl22 = new Employee("BSController2", 2, "BSController2", "BSController2", 900, new StationControl());
            ArrayList<Employee> EmployeeList7 = new ArrayList<Employee>();
            
            Employee stationControl111 = new Employee("DSController1", 1, "DSController1", "DSController1", 1000, new StationControl());
            Employee stationControl222 = new Employee("DSController2", 2, "DSController2", "DSController2", 900, new StationControl());
            ArrayList<Employee> EmployeeList8 = new ArrayList<Employee>();
            EmployeeList6.add(stationControl1);
            EmployeeList6.add(stationControl2);
            EmployeeList7.add(stationControl11);
            EmployeeList7.add(stationControl22);
            EmployeeList8.add(stationControl111);
            EmployeeList8.add(stationControl222);
            EmployeeDirectory e6 = new EmployeeDirectory(EmployeeList6);
            EmployeeDirectory e7 = new EmployeeDirectory(EmployeeList7);
            EmployeeDirectory e8 = new EmployeeDirectory(EmployeeList8);
            
            Employee railMan1 = new Employee("NRailwayManager1", 1, "NRailwayManager1", "NRailwayManager1", 10000, new RailwayComManager());
            Employee railMan2 = new Employee("ERailwayManager1", 1, "ERailwayManager1", "ERailwayManager1", 10000, new RailwayComManager());
            
            Employee RService1 = new Employee("NRailService1", 2, "NRailService1", "NRailService1", 500, new CustomerService());
            Employee RService2 = new Employee("ERailService1", 2, "ERailService1", "ERailService1", 500, new CustomerService());
            
            Employee vRService1 = new Employee("NVIPRailService1", 3, "NVIPRailService1", "NVIPRailService1", 1500, new VIPCustomerService());
            Employee vRService2 = new Employee("ERailVIPService1", 3, "ERailVIPService1", "ERailVIPService1", 1500, new VIPCustomerService());
            
            Employee RailCaptain1 = new Employee("NRailCaptain1", 4, "NRailCaptain1", "NRailCaptain1", 15000, new TrainCaptain());
            Employee RailCaptain2 = new Employee("NRailCaptain2", 5, "NRailCaptain2", "NRailCaptain2", 15000, new TrainCaptain());
            Employee RailCaptain11 = new Employee("ERailCaptain1", 4, "ERailCaptain1", "ERailCaptain1", 15000, new TrainCaptain());
            Employee RailCaptain22 = new Employee("ERailCaptain2", 5, "ERailCaptain2", "ERailCaptain2", 15000, new TrainCaptain());
            
            ArrayList<Employee> EmployeeList9 = new ArrayList<Employee>();
            EmployeeList9.add(railMan1);
            EmployeeList9.add(RService1);
            EmployeeList9.add(vRService1);
            EmployeeList9.add(RailCaptain1);
            EmployeeList9.add(RailCaptain2);
            
            ArrayList<Employee> EmployeeList10 = new ArrayList<Employee>();
            EmployeeList10.add(railMan2);
            EmployeeList10.add(RService2);
            EmployeeList10.add(vRService2);
            EmployeeList10.add(RailCaptain11);
            EmployeeList10.add(RailCaptain22);
            
            EmployeeDirectory e9 = new EmployeeDirectory(EmployeeList9);
            EmployeeDirectory e10 = new EmployeeDirectory(EmployeeList10);
            
            Employee sysadmin = new Employee("sysadmin", 0, "sysadmin", "sysadmin", 0, new sysAdmin());
            
            UserAccount NAirUser1 = new UserAccount("NUser1","NUser1", 1, "NPHan", new Customer(), new requestDirectory());
            UserAccount NAirUser2 = new UserAccount("NUser2","NUser2", 2, "NLQi", new Customer(), new requestDirectory());
            UserAccount NAirUser3 = new UserAccount("NUser3","NUser3", 3, "NElias", new VIPCustomer(), new requestDirectory());
            UserAccount EAirUser1 = new UserAccount("EUser1","EUser1", 1, "EPHan", new Customer(), new requestDirectory());
            UserAccount EAirUser2 = new UserAccount("EUser2","EUser2", 2, "ELQi", new Customer(), new requestDirectory());
            UserAccount EAirUser3 = new UserAccount("EUser3","EUser3", 3, "EElias", new VIPCustomer(), new requestDirectory());
            
            UserAccountDirectory u1 = new UserAccountDirectory();
            u1.addUser(NAirUser1);
            u1.addUser(NAirUser2);
            u1.addUser(NAirUser3);
            UserAccountDirectory u2 = new UserAccountDirectory();
            u2.addUser(EAirUser1);
            u2.addUser(EAirUser2);
            u2.addUser(EAirUser3);
            
            
            UserAccount NRailUser1 = new UserAccount("NUser1","NUser1", 1, "NPHan", new Customer(), new requestDirectory());
            UserAccount NRailUser2 = new UserAccount("NUser1","NUser1", 2, "NLQi", new Customer(), new requestDirectory());
            UserAccount NRailUser3 = new UserAccount("NUser3","NUser3", 3, "NElias", new VIPCustomer(), new requestDirectory());
            UserAccount ERailUser1 = new UserAccount("EUser1","EUser1", 1, "EPHan", new Customer(), new requestDirectory());
            UserAccount ERailUser2 = new UserAccount("EUser2","EUser2", 2, "NLQi", new Customer(), new requestDirectory());
            UserAccount ERailUser3 = new UserAccount("EUser3","EUser3", 3, "NElias", new VIPCustomer(), new requestDirectory());
            
            UserAccountDirectory u3 = new UserAccountDirectory();
            u3.addUser(NRailUser1);
            u3.addUser(NRailUser2);
            u3.addUser(NRailUser3);
            UserAccountDirectory u4 = new UserAccountDirectory();
            u4.addUser(ERailUser1);
            u4.addUser(ERailUser2);
            u4.addUser(ERailUser3);
            
            SimpleDateFormat ft = new SimpleDateFormat ("MM-dd hh:mm");
            
            String time1 = "12-22 04:50";
            String time2 = "12-22 06:50";
            String time3 = "12-15 18:00";
            String time4 = "12-16 19:00";
            String time5 = "12-19 20:00";
            Date date1 = ft.parse(time1);
            Date date2 = ft.parse(time2);
            Date date3 = ft.parse(time3);
            Date date4 = ft.parse(time4);
            Date date5 = ft.parse(time5);
            
            Flight flight1 = new Flight("1", "NAC", "Normal", "Not Started", date1, null, 1);
            flight1.setFlight("NewYork", "Boston", airplane6, AirCaptain11, 90, 36, 8, 100.0, 200.0, 500.0);
            
            Flight flight2 = new Flight("3", "NAC", "VIP", "Not Started", date2, null, 2);
            flight2.setFlight("Boston", "NewYork", airplane5, AirCaptain22, 0, 0, 6, 0, 0, 200000.0);
            
            ArrayList<String> sL = new ArrayList<String>();
            sL.add("Danville");
            sL.add("Boston");
            sL.add("NewYork");
            ArrayList<String> sL2 = new ArrayList<String>();
            sL2.add("Boston");
            sL2.add("NewYork");
            TrainLine trainLine1= new TrainLine("1", "NRC", "Normal", "Not Started", date3, null, 1);
            trainLine1.setTrainLine(sL2, 0, RailCaptain1, train3, 200, 100, 40, 10, 100.0, 200.0, 400.0, 800.0);
            
            TrainLine trainLine2= new TrainLine("3", "NRC", "VIP", "Not Started", date4, null, 2);
            trainLine2.setTrainLine(sL, 0, RailCaptain2, train2, 200, 100, 40, 10, 100.0, 200.0, 400.0, 800.0);
            
            requestDirectory requestd1 = new requestDirectory();
            requestd1.addRequest(flight1);
            requestd1.addRequest(flight2);
            
            requestDirectory requestd2 = new requestDirectory();
            requestd2.addRequest(trainLine1);
            requestd2.addRequest(trainLine2);
            
            Landing land1 = new Landing("4", "NAir", "Takeoff", "Unsolved", date1, null, 1, flight1, null, null);
            
            requestDirectory requestd3 = new requestDirectory();
            requestd3.addRequest(land1);
            
            Airport airport1 = new Airport("NewYorkAirport", "NAir", e1, requestd3, road1List1, GateList1);
            Airport airport2 = new Airport("BostonAirport", "BAir", e2, new requestDirectory(), road1List2, GateList2);
            Airport airport3 = new Airport("DanvilleAirport", "DAir", e3, new requestDirectory(), road1List3, GateList3);
            
            OrganizationDirectory or1 = new OrganizationDirectory();
            or1.addOrganization(airport1);
            or1.addOrganization(airport2);
            or1.addOrganization(airport3);
            
            Station station1 = new Station("NewYorkStation", "NS", e6,new requestDirectory(),EnterList1);
            Station station2 = new Station("BostonStation", "NB", e7,new requestDirectory(),EnterList2);
            Station station3 = new Station("DanvilleStation", "ND", e8,new requestDirectory(),EnterList3);
            
            OrganizationDirectory or2 = new OrganizationDirectory();
            or2.addOrganization(station1);
            or2.addOrganization(station2);
            or2.addOrganization(station3);
            
            AirlineCompany ar1 = new AirlineCompany("NorthAirlineCompany", "NAC", u1, e4,requestd1, NairplaneList);
            AirlineCompany ar2 = new AirlineCompany("EasternAirlineCompany", "EAC", u2, e5,new requestDirectory(), EairplaneList);
            OrganizationDirectory or3 = new OrganizationDirectory();
            or3.addOrganization(ar1);
            or3.addOrganization(ar2);
            
            RailwayCompany rc1 = new RailwayCompany("NorthRailwayCompany", "NRC", u3, e9, requestd2,TrainList1);
            RailwayCompany rc2 = new RailwayCompany("EasternRailwayCompany", "NRC", u4, e10, new requestDirectory(),TrainList2);
            OrganizationDirectory or4 = new OrganizationDirectory();
            or4.addOrganization(rc1);
            or4.addOrganization(rc2);
            
            Enterprise en1 = new Enterprise("Airport", 1, or1);
            Enterprise en2 = new Enterprise("Station", 2, or2);
            Enterprise en3 = new Enterprise("AirlineCompany", 3, or3);
            Enterprise en4 = new Enterprise("RailwayCompany", 4, or4);
            
            ArrayList<Enterprise> enlist = new ArrayList<Enterprise>();
            enlist.add(en1);
            enlist.add(en2);
            enlist.add(en3);
            enlist.add(en4);
            
            EnterpriseDirectory end = new EnterpriseDirectory(enlist);
            system.setAdmin(sysadmin);
            system.setName("TravelSystem");
            system.setEnterpriseDirectory(end);
            
            
        return system;
    }
    
}
