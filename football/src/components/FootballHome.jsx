import React from "react";
import { Link } from "react-router-dom";
import bgImage from "../assets/efootball-background-og.jpg";

export default function FootballHome() {
  return (
    <div className="app">
      {/* Hero Section */}
      <section className="hero">
        <div className="hero-overlay">
          <h1>E-Football League</h1>
          <p>Dream big, play hard, achieve greatness</p>
        </div>
      </section>

      {/* Sport for Change Section */}
      <section className="teams" id="sport-for-change">
        <h2>Sport for Change</h2>
        <blockquote className="quote">
          “Sport has the power to change the world... It has the power to inspire. It has the power to unite people in a way that little else does.”
          <br /><em>– Nelson Mandela</em>
        </blockquote>
        <p>
          At E-Football League, we believe sport is more than competition — it's a movement. A force that brings people together, breaks barriers, and builds hope.
        </p>
        <p>
          We support organizations that use football to promote education, inclusion, and mental well-being. Whether it's grassroots programs or global campaigns, we stand with those who play for a purpose.
        </p>
        <div className="highlight-box">
          ❤️ Supporting “Football for Good” initiatives with free access and visibility.
        </div>
      </section>

      {/* Footer */}
      <footer className="footer">
        <p>© 2025 E-football league</p>
        <div className="socials">
          <a href="#">Twitter</a> | <a href="#">Instagram</a> | <a href="#">YouTube</a>
        </div>
      </footer>

      {/* Styles */}
      <style jsx>{`
        .app {
          font-family: Arial, sans-serif;
          color: #222;
          background: #fff;
        }
        .hero {
          position: relative;
          text-align: center;
          height: 90vh;
          min-height: 350px;
          max-height: 700px;
          background: url(${bgImage}) no-repeat center center/cover;
          color: white;
          display: flex;
          flex-direction: column;
          justify-content: center;
          align-items: center;
          padding: 0 1rem;
        }
        .hero h1 {
          font-size: clamp(1.8rem, 5vw, 3rem);
          margin-bottom: 1rem;
          text-shadow: 2px 2px 6px rgba(0,0,0,0.7);
        }
        .hero p {
          font-size: clamp(1rem, 2.5vw, 1.5rem);
          text-shadow: 1px 1px 4px rgba(0,0,0,0.7);
        }
        .hero-overlay {
          background: none;
          padding: 0;
          border-radius: 0;
          display: block;
          text-align: center;
        }
        .teams {
          padding: 2rem;
        }
        .teams h2 {
          font-size: 1.8rem;
          margin-bottom: 0.5rem;
        }
        .quote {
          font-size: 1.2rem;
          font-style: italic;
          margin: 1rem 0;
          padding-left: 1rem;
          border-left: 4px solid #ccc;
          color: #444;
        }
        .highlight-box {
          background: #f9f9f9;
          border-left: 5px solid #e63946;
          padding: 1rem;
          margin-top: 1rem;
          font-weight: bold;
          color: #333;
        }
        .footer {
          text-align: center;
          padding: 1rem;
          border-top: 1px solid #eee;
          margin-top: 2rem;
        }
        .socials a {
          text-decoration: none;
          margin: 0 0.5rem;
          color: #333;
        }
      `}</style>
    </div>
  );
}