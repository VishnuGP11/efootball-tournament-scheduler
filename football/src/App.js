import React from "react";
import Navbar from "./components/Navbar";
import FootballHome from "./components/FootballHome";
import TeamDetailsPage from "./components/TeamDetailsPage";
import AddTournament from "./components/AddTournament";
import TournamentDetails from "./components/TournamentDetails";
import MatchDetails from "./components/MatchDetails";
import { Routes, Route } from "react-router-dom";

function App() {
  return (
    <div className="App">
      <Navbar />
      <Routes>
        <Route path="/" element={<FootballHome />} />
        <Route path="/teams/:teamId" element={<TeamDetailsPage />} />
        <Route path="/addTournament" element={<AddTournament />} />
        <Route path="/tournament-details" element={<TournamentDetails />} />
        <Route path="/match-details/:matchId" element={<MatchDetails />} />
      </Routes>
    </div>
  );
}

export default App;
