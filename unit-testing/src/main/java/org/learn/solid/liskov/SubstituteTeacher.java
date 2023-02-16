package org.learn.solid.liskov;

// this class should not inherit from the Teacher class because they do not teach
// it is a violation of the LSP principle

// doesn't teach, it is just a school staff
public class SubstituteTeacher extends SchoolStaff {

    // what we could do is create a degenerate method
    // it is bad practice & it violates LSP
    // this is an anti-pattern that should be avoided at all cost
    //    @Override
    //    public void teach() {
            // do nothing
            // throws new Exception("cannot create instance of this class.")
    //    }

    // also, never downcast Teacher to concrete derivative and check for a case where they are a
    // substitute in the client code
    // we do not need "instance of" statements


    // solution is to pull out Substitute Teacher from this relationship
    // because it is not a Teacher as per our definition
}
