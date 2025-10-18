import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './AddTournament.css';

const AddTournament = () => {
  const [tournamentName, setTournamentName] = useState('');
  const [numTeams, setNumTeams] = useState(2);
  const [typeOfSchedule, setTypeOfSchedule] = useState('round robin');
  const navigate = useNavigate();

const handleSubmit = async (e) => {
  e.preventDefault();

  const payload = {
    tournamentName,
    numberOfTeams: numTeams,
    typeOfSchedule
  };

  try {
    const createRes = await fetch('http://localhost:8008/tournaments/createTournament', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(payload)
    });

    console.log(createRes);
    
    if (!createRes.ok) {
      alert("Tournament creation failed.");
      return;
    }

    const tournamentDetails = await createRes.json();
    console.log(tournamentDetails);

    // ✅ Directly use the response to navigate
    navigate('/tournament-details', { state: { tournamentDetails } });
  } catch (error) {
    console.error("Error:", error);
    alert("Something went wrong.");
  }
};

  return (
    <div style={{ padding: '2rem', fontFamily: 'Segoe UI Emoji' }}>
      <h2>🏆 Add Tournament</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Tournament Name:</label>
          <input
            type="text"
            value={tournamentName}
            onChange={(e) => setTournamentName(e.target.value)}
            required
          />
        </div>

        <div>
          <label>Number of Teams:</label>
          <input
            type="number"
            min="2"
            value={numTeams}
            onChange={(e) => setNumTeams(parseInt(e.target.value))}
            required
          />
        </div>

        <div>
          <label>Type of Tournament:</label>
          <select
            value={typeOfSchedule}
            onChange={(e) => setTypeOfSchedule(e.target.value)}
          >
            <option value="round robin">Round Robin</option>
            <option value="elimination">Elimination</option>
          </select>
        </div>

        <button type="submit" style={{ marginTop: '1rem' }}>Submit Tournament</button>
      </form>
    </div>
  );
};

export default AddTournament;