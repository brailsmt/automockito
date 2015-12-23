The main idea I have is to create a graph of object dependencies within unit tests and automatically generate Object
generators.  The idea is that of property based testing, a la Haskell's QuickCheck.  Java does not have the strong type
system that Haskell does, so it complicates matters.

As a test writer, I do not really care about specific values of parameters used in tests.  I am more concerned with
categories of inputs that are valid and invalid, as well as special cases like nulls, empty strings/lists.  I
particularly care about the values in the boundary areas between what is valid and what isn't valid.

One of the core concepts behind this is to define what is and isn't a valid input for a given test case.  In general,
what is needed is a way to generate test values.  The first step to creating an automocking framework is to build a set
of generator functors that can create specific types.  For the well known classes, such as primitives and Strings, List,
etc..., these can be predefined.

However, in most real world situations, in order to define one generator, another will be required to generate values
for a field.

For example:
```java
public class Foo {
  private int foo;
  public Foo(int) {/* do stuff */}
}

public class Bar {
  private Foo foo;
  public Bar(Foo) {/* do stuff */}
}
```

In order to create a Bar object, I need to know how to create a Foo object.  If I provide the following generators:
```java
  generator(Foo.class, fooGenerator);
  generator(Bar.class, barGenerator);
```
With a mapping such as that, I should not need to explicitly create a Foo object to generate a Bar object.  Through
voodoo magic, aka Reflection or Annotations, I should be able to simply declare that I need a Bar object generated and
have a new Bar object with a valid Foo object as a member of Bar.

In order to implement an automocking framework I need to begin with following:
 # Specify a generator interface
 # Provide some basic generators for primitives
 # Provide a generator registration facility
 # Build dependent objects if generators are registered for each dependency


At this point, this isn't really doing anything with mock objects...  that will have to come later
