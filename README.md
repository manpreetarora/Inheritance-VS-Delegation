# Inheritance-VS-Delegation
This program in Java shows how we can achieve the same objective by replacing inheritance by delegation. 

The program in Delegation.java defines four classes, C1, C11, C111, and C112, where the classes C111 and C112 extend C11 which in turn extends C1.
The result of delegation transformation is four classes called D1, D11, D111, and D112 which correspond to C1, C11, C111, and C112 respectively,
but do not make use of class inheritance. The classes D1, D11, D111, and D112 implement interfaces I1, I11, I111 and I112 respectively, where the interfaces I111 and I112 inherit from I11 which in turn inherits from I1.
A sequence diagram generated through JIVE demonstrates how the code works.
