import React, { useEffect, useState } from "react";
import { useParams, Link } from "react-router-dom";

export default function TeamDetailsPage() {
  const { teamId } = useParams();
  const [team, setTeam] = useState(null);
  const [error, setError] = useState(null);

  useEffect(() => {
    if (!teamId) {
      console.warn("No teamId found in URL");
      setError("Invalid team ID.");
      return;
    }

    const url = `http://localhost:8090/pes/teams/${Number(teamId)}`;
    console.log("Fetching team from:", url);

    fetch(url)
      .then(res => {
        console.log("Response status:", res.status);
        if (!res.ok) {
          throw new Error(`Failed to fetch team. Status: ${res.status}`);
        }
        return res.json();
      })
      .then(data => {
        console.log("Fetched team data:", data);
        setTeam(data);
      })
      .catch(err => {
        console.error("Error fetching team:", err);
        setError("Failed to load team details. Please try again later.");
      });
  }, [teamId]);

  if (error) {
    return (
      <div className="text-red-600">
        <p>{error}</p>
        <button onClick={() => window.location.reload()} className="mt-2 bg-blue-500 text-white px-3 py-1 rounded">
          Retry
        </button>
      </div>
    );
  }

  if (!team) {
    return (
      <div className="loading">
        <p>Loading team details...</p>
        <div className="spinner" />
        <style jsx>{`
          .spinner {
            margin: 1rem auto;
            width: 24px;
            height: 24px;
            border: 4px solid #ccc;
            border-top: 4px solid #333;
            border-radius: 50%;
            animation: spin 1s linear infinite;
          }
          @keyframes spin {
            to { transform: rotate(360deg); }
          }
        `}</style>
      </div>
    );
  }

  const players = Array.isArray(team.players) ? team.players : [];
  const formation = { Goalkeeper: [], Defenders: [], Midfielders: [], Forwards: [] };
  players.forEach(player => {
    const pos = (player.position || "").toLowerCase();
    if (pos.includes("goalkeeper")) formation.Goalkeeper.push(player);
    else if (pos.includes("defender")) formation.Defenders.push(player);
    else if (pos.includes("midfielder")) formation.Midfielders.push(player);
    else formation.Forwards.push(player);
  });

  return (
    <div className="team-detail p-6">
      <Link to="/" className="text-blue-600 hover:underline mb-4 inline-block">
        ← Back to Teams
      </Link>
      <h1 className="text-2xl font-bold mb-2">{team.name}</h1>
      <p className="mb-1"><strong>Coach:</strong> {team.coach}</p>
      <p className="mb-4"><strong>Owner:</strong> {team.owner}</p>

      <h2 className="text-xl font-semibold mb-2">Players (Formation)</h2>
      <div className="formation">
        {Object.entries(formation).map(([position, players]) => (
          <div key={position} className="position-row">
            <h3>{position}</h3>
            <div className="players-row">
              {players.map(p => (
                <div key={p.playerId} className="player-card">{p.name}</div>
              ))}
            </div>
          </div>
        ))}
      </div>

      <style jsx>{`
        .formation {
          display: flex;
          flex-direction: column;
          gap: 1rem;
        }
        .position-row h3 {
          font-weight: bold;
          margin-bottom: 0.5rem;
        }
        .players-row {
          display: flex;
          justify-content: center;
          gap: 1rem;
          flex-wrap: wrap;
        }
        .player-card {
          padding: 0.5rem 1rem;
          border: 1px solid #ccc;
          border-radius: 4px;
          text-align: center;
        }
      `}</style>
    </div>
  );
}