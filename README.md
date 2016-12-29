# CS-102-Final-Assignment
Final Assignment With GUI For CS

Brief description of submitted files:

src/LinkedList.java

    Stores a linked list of generic nodes, as many as the user wants
    isEmpty() returns whether the head is null
    add(T inputCountry) takes a generic T and adds it to the end of the list
    contains(T inputCountry) checks if name of T can be found in the list and returns the country
    toString() returns a string of info about every node in list
    getIndex(int index) returns the country at a specified index
    insertAtIndex(T iC, int index) inserts a specified T at a specified index

src/Node.java

    A single object stores a node, and can also store the next node
    Appropriate setters and getters for each parameter

src/SubscriptionYear.java

    An object consists of a year and the double array of subscriptions for the year
    Getters and setters, and a toString() function

src/Country.java

    One object contains a linked list of type Subscription Year, holding all country data
    addSubscriptionYear() Adds a subscription year to the linked list
    getNumSubscriptionsForPeriod() Returns total subscriptions in a period
    toString() Returns a string representation of the country

src/CSVReader.java

    Scans the csv file, and creates a 2d double array cellularDataTable of subscriptions by year by country
    getCountryNames() returns country names
    getYearLabels() returns year labels
    getParsedTable() returns the cellular data table

src/TestGraphView.java

    Contains the main function
    Tests the classes included in the submission by adding countries and printing the output

src/ColoredPoint.java

    Stores the data for a single colored point to be added to the graph
 
src/GraphView.java

    Class which prints the graph of the subscriptions vs years
    Contains a linked list of plotted data sets for country
    paintComponent() iterates through the created linked list and graphs individual points
 
src/ColoredPoint.java

    Stores a country's name, and a linked list of ColoredPoints for the individual country.
    Contains getters for data values and an add function
    
resources/cellular.csv

    A CSV (Comma Separated Value) file.
    Containts the World Development Indicator values for countries by year
    For some reason, this automatically opens in excel, so I have to use it as a .txt file instead

RUN.txt

    console output of TestCountryList.java

README.txt

    description of submitted files
