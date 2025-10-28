import React, { useEffect, useState } from 'react';
import { useLocation, useNavigate, useParams } from 'react-router-dom';

const TournamentDetails = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const { tournamentId: paramTournamentId } = useParams();

  const initialTournament = location.state?.tournamentDetails;
  const tournamentId = initialTournament?.tournamentId || paramTournamentId;

  const [tournament, setTournament] = useState(initialTournament || null);
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(!initialTournament);

  useEffect(() => {
    if (!tournamentId) {
      setError("Tournament ID missing.");
      return;
    }

     fetch(`http://localhost:8008/tournaments/${tournamentId}/details`)
      .then(res => {
        if (!res.ok) throw new Error("Failed to fetch tournament details");
        return res.json();
      })
      .then(data => {
        setTournament(data);
        setLoading(false);
      })
      .catch(err => {
        console.error("Error fetching tournament:", err);
        setError("❌ Failed to refresh tournament details.");
        setLoading(false);
      });
  }, [tournamentId]);

  if (error) {
    return (
      <div style={styles.container}>
        <h2>❌ Error</h2>
        <p>{error}</p>
        <button onClick={() => navigate('/')} style={styles.button}>Go Home</button>
      </div>
    );
  }

  if (loading || !tournament) {
    return (
      <div style={styles.container}>
        <h2>⏳ Loading tournament details...</h2>
        <div style={styles.spinner} />
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
              <span
                style={{ textDecoration: 'none', color: 'inherit', cursor: 'pointer' }}
                onClick={async () => {
                  try {
                    const res = await fetch(`http://localhost:8008/team/team-details/${team.teamId}`);
                    if (!res.ok) throw new Error('Failed to fetch team details');
                    const teamDetails = await res.json();
                    navigate(`/team/${team.teamId}`, { state: { teamDetails } });
                  } catch (err) {
                    console.error('Error fetching team:', err);
                    alert('Failed to load team details.');
                  }
                }}
              >
                {team.teamName}
              </span>
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
              })}
            >
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
  },
  spinner: {
    margin: '1rem auto',
    width: '24px',
    height: '24px',
    border: '4px solid #ccc',
    borderTop: '4px solid #333',
    borderRadius: '50%',
    animation: 'spin 1s linear infinite'
  }
};

export default TournamentDetails;