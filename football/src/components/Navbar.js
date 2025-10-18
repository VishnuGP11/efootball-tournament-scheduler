import React from "react";
import "./Navbar.css";

export default function Navbar() {
  return (
    <header className="header">
      <div className="logo">E-football tournament scheduler</div>
      <nav className="nav">
        <a href="/">Home</a>
        <a href="teams">Teams</a>
        <a href="addTournament">Create Tournament</a>
        <a href="standings">Current Standing</a>
        <button className="signin">Sign in</button>
        <button className="register">Register</button>
      </nav>
    </header>
  );
}
