## Design Patterns

References and samples for common design patterns.

| Creational                            | Structural                | Behavioural                                           |
|---------------------------------------|---------------------------|-------------------------------------------------------|
|[Abstract Factory](#abstract-factory)  |[Adapter](#adapter)        |[Chain of Responsibility](#chain-of-responsibility)    |
|[Builder](#builder)                    |[Bridge](#bridge)          |[Command](#command)                                    |
|[Factory Method](#factory-method)      |[Composite](#composite)    |[Interpreter](#interpreter)                            |
|[Singleton](#singleton)                |[Decorator](#decorator)    |[Iterator](#iterator)                                  |
|[Prototype](#prototype)                |[Facade](#facade)          |[Mediator](#mediator)                                  |
|                                       |[Flyweight](#flyweight)    |[Memento](#memento)                                    |
|                                       |[Proxy](#proxy)            |[Observer](#observer)                                  |
|                                       |                           |[State](#state)                                        |
|                                       |                           |[Strategy](#strategy)                                  |
|                                       |                           |[Template Method](#template-method)                    |
|                                       |                           |[Visitor](#visitor)                                    |

##### Common Cause for Redesign
 - Creating an object by specifying a class explicitly
    - [Abstract Factory](#abstract-factory)
    - [Factory Method](#factory-method)
    - [Prototype](#prototype)
 - Dependence on specific operations
    - [Chain of Responsibility](#chain-of-responsibility)
    - [Command](#command)
 - Dependence on hardware and software platform
    - [Abstract Factory](#abstract-factory)
    - [Bridge](#bridge)
 - Dependence on object representation or implementation
    - [Abstract Factory](#abstract-factory)
    - [Bridge](#bridge)
    - [Memento](#memento)
    - [Proxy](#proxy)
 - Algorithmic Dependencies
    - [Builder](#builder)
    - [Iterator](#iterator)
    - [Strategy](#strategy)
    - [Template Method](#template-method)
    - [Visitor](#visitor)
 - Tight Coupling
    - [Abstract Factory](#abstract-factory)
    - [Bridge](#bridge)
    - [Chain of Responsibility](#chain-of-responsibility)
    - [Command](#command)
    - [Facade](#facade)
    - [Mediator](#mediator)
    - [Observer](#observer)
 - Extending functionality by subclassing
    - [Bridge](#bridge)
    - [Chain of Responsibility](#chain-of-responsibility)
    - [Composite](#composite)
    - [Decorator](#decorator)
    - [Observer](#observer)
    - [Strategy](#strategy)
 - Inability to alter classes conveniently
    - [Adapter](#adapter)
    - [Decorator](#decorator)
    - [Visitor](#visitor)
 
 
 
#### Abstract Factory
Provides interface for creating families of related or dependent objects without specifying concrete classes

Use when
 - System should be independent of how products are created, composed and represented
 - System should be configured with one of multiple families of products
 - Family of related product objects is designed to be used together and should be enforced
 - Want to provide a class library of products and only reveal their interfaces
 
Consequences
 - It isolates concrete classes
 - It makes exchanging product families easy
 - It promotes consistency among products
 - Supporting new kinds of products is difficult

#### Adapter
#### Bridge
#### Builder 
#### Chain of Responsibility
#### Command
#### Composite
#### Decorator
#### Facade
#### Factory Method
#### Flyweight
#### Interpreter
#### Iterator
#### Mediator
#### Memento
#### Observer
#### Prototype
#### Proxy
#### Singleton
#### State
#### Strategy
#### Template Method
#### Visitor
