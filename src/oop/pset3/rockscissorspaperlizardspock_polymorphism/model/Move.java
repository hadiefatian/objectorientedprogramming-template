package oop.pset3.rockscissorspaperlizardspock_polymorphism.model;

public interface Move {

    MoveType getType();

    boolean defeats(Move move);
}
