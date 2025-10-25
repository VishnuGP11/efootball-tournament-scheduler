import React, { useEffect, useState } from 'react';
import { useLocation, useNavigate, useParams } from 'react-router-dom';

const MatchDetails = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const { matchId } = useParams();

  const [match, setMatch] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

 useEffect(() => {
  let isCancelled = false;

  const fetchMatchDetails = async () => {
    try {
      const res = await fetch(`http://localhost:8008/match/match-details/${matchId}`);
      const data = await res.json();
      if (!isCancelled) setMatch(data);
    } catch (err) {
      if (!isCancelled) setError(err.message);
    } finally {
      if (!isCancelled) setLoading(false);
    }
  };

  fetchMatchDetails();

  return () => {
    isCancelled = true;
  };
}, [matchId]);


  if (loading) {
    return <div style={styles.container}><h2>⏳ Loading match details...</h2></div>;
  }

  if (error || !match) {
    return (
      <div style={styles.container}>
        <h2>❌ Match not found</h2>
        <button onClick={() => navigate('/')} style={styles.button}>Go Home</button>
      </div>
    );
  }

  return (
    <div style={styles.container}>
      <h2 style={styles.heading}>⚽ Match Details</h2>
      <p><strong>Team A:</strong> {match.teamA}</p>
      <p><strong>Team B:</strong> {match.teamB}</p>
      <p><strong>Score:</strong> {match.goalsScoredByTeamA} - {match.goalsScoredByTeamB}</p>
      <button onClick={() => navigate(-1)} style={styles.button}>🔙 Back</button>
    </div>
  );
};

const styles = {
  container: {
    padding: '2rem',
    fontFamily: 'Segoe UI Emoji',
    maxWidth: '600px',
    margin: '0 auto',
    backgroundColor: '#fefefe',
    borderRadius: '10px',
    boxShadow: '0 0 10px rgba(0,0,0,0.1)'
  },
  heading: {
    marginBottom: '1rem',
    color: '#333'
  },
  button: {
    marginTop: '2rem',
    padding: '0.6rem 1.2rem',
    fontSize: '1rem',
    backgroundColor: '#0078D4',
    color: '#fff',
    border: 'none',
    borderRadius: '6px',
    cursor: 'pointer'
  }
};

export default MatchDetails;