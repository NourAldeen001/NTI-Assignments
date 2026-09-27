Books (Owning side) (M) ========= (M) Categories
================================================
* Book class has a @JoinTable with foreign keys

Books (Owning side) (M) ========= (1) Authors
================================================
* Book class has a foreign key

Books (Owning side) (M) ========= (1) Publishers
================================================
* Book class has a foreign key

Inheritance Type Used
=====================
                         Person(id, name) InheritanceType.JOINED
                                |
        ________________________ ________________________
        |                                               |
      Customer(loyaltyLevel)                          Employee(salary)

3 tables
========
                          Customer                      Employee
        Person            loyalty_level | id(FK)        salary | id(FK)
        name | id         Gold          |  1            45000  |  2
         SS  | 1 __________________________|                      |
         MM  | 2 _________________________________________________|