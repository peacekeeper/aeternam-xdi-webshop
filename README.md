<a href="http://projectdanube.org/" target="_blank"><img src="http://projectdanube.github.com/xdi2/images/projectdanube_logo.png" align="right"></a>
<img src="http://projectdanube.github.com/xdi2/images/logo64.png"><br>

This is a website representing a webshop.

This is part of a demo for [ÆTERNAM](https://aeternam.eu/), it shows how a passenger can buy a train ticket while staying in control of their data in a "self-sovereign" way. A "Passenger Name Record" (PNR) is created and governed by XDI link contracts that allow different involved parties to view and update it in various ways.

### Information

* [Screencast](https://vimeo.com/191811593)
* [Diagrams](https://projectdanube.github.io/aeternam-xdi-webshop/XDI-AETERNAM-demo.pdf)

### Details

See the following wiki pages for more technical details:

 * [Components and Identifiers](https://github.com/projectdanube/aeternam-xdi-webshop/wiki/Components-and-Identifiers)
 * [Maria's Personal Data](https://github.com/projectdanube/aeternam-xdi-webshop/wiki/Maria's-Personal-Data)
 * [Train Ticket](https://github.com/projectdanube/aeternam-xdi-webshop/wiki/Train-Ticket)
 * [Request for Personal Data](https://github.com/projectdanube/aeternam-xdi-webshop/wiki/Request-for-Personal-Data)
 * [Request for Storing Ticket](https://github.com/projectdanube/aeternam-xdi-webshop/wiki/Request-for-Storing-Ticket)
 * [Ticket Link Contract](https://github.com/projectdanube/aeternam-xdi-webshop/wiki/Ticket-Link-Contract)
 * [Ticket Update](https://github.com/projectdanube/aeternam-xdi-webshop/wiki/Ticket-Update)

### How to build

First, you need to build the main [XDI2](http://github.com/projectdanube/xdi2) project.

After that, just run

    mvn clean install jetty:run

Then the website is available at

	http://localhost:7202/

### Community

Google Group: http://groups.google.com/group/xdi2

IRC: irc://irc.freenode.net:6667/xdi
