import React from 'react';
import { Link } from 'react-router-dom';
import { useLocation, useNavigate } from 'react-router-dom';

const TournamentDetails = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const tournament = location.state?.tournamentDetails;

  if (!tournament) {
    return (
      <div style={{ padding: '2rem', fontFamily: 'Segoe UI Emoji' }}>
        <h2>❌ No tournament data found</h2>
        <button onClick={() => navigate('/')} style={styles.button}>Go Home</button>
      </div>
    );
  }

  return (
    <div style={styles.container}>
      <h2 style={styles.heading}>🏆 Tournament Details</h2>
      <p><strong>Name:</strong> {tournament.tournamentName}</p>
      <p><strong>Type:</strong> {tournament.tournamentType}</p>

      <div style={styles.section}>
  <h3>👥 Teams</h3>
  <ul style={styles.list}>
    {tournament.teams.map((team, index) => (
      <li key={index} style={styles.listItem}>
        <Link
          to={`/team/${encodeURIComponent(team)}`}
          style={{ textDecoration: 'none', color: 'inherit' }}
        >
          {team}
        </Link>
      </li>
    ))}
  </ul>
</div>


      <div style={styles.section}>
        <h3>⚔️ Matchups</h3>
        <ul style={styles.matchList}>
          {tournament.matchUp.map((match, index) => (
            <li
  key={index}
  style={{ ...styles.matchItem, cursor: 'pointer' }}
  onClick={() => navigate(`/match-details/${match.matchId}`, {
  state: { match, matchIndex: index + 1 }
})}>
  <div style={styles.matchRow}>
    <span><strong>Match {index + 1}:</strong> {match.teamA} vs {match.teamB}</span>
    <span style={styles.score}>{match.goalsScoredByTeamA}-{match.goalsScoredByTeamB}</span>
  </div>
</li>


          ))}
        </ul>
      </div>

      <button onClick={() => navigate('/')} style={styles.button}>🏠 Back to Home</button>
    </div>
  );
};

const styles = {
  container: {
    padding: '2rem',
    fontFamily: 'Segoe UI Emoji',
    maxWidth: '700px',
    margin: '0 auto',
    backgroundColor: '#f9f9f9',
    borderRadius: '10px',
    boxShadow: '0 0 10px rgba(0,0,0,0.1)'
  },
  heading: {
    marginBottom: '1rem',
    color: '#333'
  },
  section: {
    marginTop: '1.5rem'
  },
  list: {
    paddingLeft: '1.5rem'
  },
  listItem: {
    marginBottom: '0.5rem'
  },
  matchList: {
    paddingLeft: '1.5rem'
  },
  matchRow: {
  display: 'flex',
  justifyContent: 'space-between',
  alignItems: 'center'
},
score: {
  marginLeft: '1rem',
  fontWeight: 'bold',
  color: '#555'
},
  matchItem: {
    marginBottom: '0.75rem',
    backgroundColor: '#fff',
    padding: '0.75rem',
    borderRadius: '6px',
    border: '1px solid #ddd'
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

export default TournamentDetails;