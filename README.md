<h1 align = "center">
:airplane: <b><i>Tourist Agency</i></b> :airplane:
</h1>
<br />

<p align="center">
  <img src="https://github.com/jgdev-arc/TouristAgencyArc/blob/master/main.gif" alt="header">
</p>

# Learning Goal

My main objective for this application was to become more familiar with implementing design patterns in a real project. The functionality itself is fairly simple; there is a collection of panels 
that take input and display data, themed around the end user being someone who works as an agent at a tourist agency. 

# :camera_flash: **Features** :camera_flash:

- **Builder Design Pattern:** Customers can select from various offers and packages. Each package comes with different perks and accommodations. These perks and accommodations can vary in complexity. The builder design patterns helped to produce different packages using streamlined construction code.
  The builder class builds the final object (what is displayed to the user) step-by-step and is independent of other irrelevant objects.

- **Memento Design Pattern:** This application allows the agent to save the customer's information to the disk. The memento is a value object that acts as a snapshot of the originator's state. It is immutable and is passed to the data only once, via the constructor.

- **Strategy Design Pattern:** This is a behavioral design pattern that defines a family of algorithms, each in separate classes with interchangeable objects. Although there is no payment functionality in the application (only UI elements), the idea was to represent each payment
  option (PaymentStrategy.java) - such as Paypal(PaypalStrategy.java) and credit card (CreditCard.java).


## :hammer_and_wrench: Usage :hammer_and_wrench:

If the agent selects an individual or group, the packages in special offers will reflect what is currently available. 

If the agent selects a group and package , the pricing and information related to the package are displayed in the payment methods and service details panels. The payment method, paypal and credit card, are just for demonstration.

The discount is percentage based and changes according to whether the buyer is retired, a student, etc. The idea was to mimic most benefit systems used by companies in this space.

You can clone the repository or download the Zip file [here](https://github.com/jgdev-arc/TouristAgencyArc).


# :building_construction: Tech Stack :building_construction:

* [Java]([(https://openjdk.org/)](https://www.java.com/en/download/help/whatis_java.html)) - java is a multi-platform, object-oriented, and network-centric language.


# :memo: Authors :memo:
- [@jgdev-arc](https://github.com/jgdev-arc)
  
Do Reach Out :

  * [LinkedIn](https://www.linkedin.com/in/jgdev/)
  * [Twitter](https://twitter.com/jon_g_dev)



# :scroll: License :scroll:

MIT License

Copyright (c) [2023] [jgdev-arc]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
