import React, { useEffect, useState } from "react";
import { useParams, Link, useLocation } from "react-router-dom";

export default function TeamDetailsPage() {
  const { teamId } = useParams();
  const location = useLocation();
  console.log("Location state:", location.state);

  const [team, setTeam] = useState(location.state?.teamDetails || null);
  const [error, setError] = useState(null);
  const [hoverField, setHoverField] = useState(null);
  const [editableFields, setEditableFields] = useState({
    teamName: "",
    playingStyle: "",
    owner: "",
    tournamentName: ""
  });

  useEffect(() => {
    if (team) return;

    if (!teamId) {
      setError("Invalid team ID.");
      return;
    }

    const url = `http://localhost:8008/team/team-details/${teamId}`;
    fetch(url)
      .then(res => {
        if (!res.ok) throw new Error(`Failed to fetch team. Status: ${res.status}`);
        return res.json();
      })
      .then(data => setTeam(data))
      .catch(err => {
        console.error("Error fetching team:", err);
        setError("Failed to load team details.");
      });
  }, [teamId, team]);

  const handleInputChange = (field, value) => {
    setEditableFields(prev => ({ ...prev, [field]: value }));
  };

  const commitField = (field) => {
    const value = editableFields[field].trim();
    if (!value) {
      setHoverField(null);
      return;
    }

    if (field === "tournamentName") {
      setTeam(prev => ({
        ...prev,
        tournamentAssociatedWithTeamDTO: {
          ...prev.tournamentAssociatedWithTeamDTO,
          tournamentName: value
        }
      }));
    } else {
      setTeam(prev => ({ ...prev, [field]: value }));
    }

    setEditableFields(prev => ({ ...prev, [field]: "" }));
    setHoverField(null);
  };

  const handleKeyDown = (e, field) => {
    if (e.key === "Enter") {
      commitField(field);
    }
  };

  if (error) {
    return (
      <div style={styles.container}>
        <h2 style={styles.heading}>❌ Error</h2>
        <p>{error}</p>
        <button onClick={() => window.location.reload()} style={styles.button}>
          Retry
        </button>
      </div>
    );
  }

  if (!team) {
    return (
      <div style={styles.container}>
        <h2 style={styles.heading}>⏳ Loading team details...</h2>
        <div style={styles.spinner} />
      </div>
    );
  }

  return (
    <div style={styles.container}>
      <Link to="/" style={styles.link}>← Back to Teams</Link>
      <h2 style={styles.heading}>👕 Team Details</h2>

      {/* Team Name */}
      <div
        style={styles.field}
        onMouseEnter={() => setHoverField("teamName")}
        onMouseLeave={() => setHoverField(null)}
      >
        <strong>Team Name:</strong>{" "}
        {hoverField === "teamName" ? (
          <input
            type="text"
            value={editableFields.teamName}
            onChange={e => handleInputChange("teamName", e.target.value)}
            onBlur={() => commitField("teamName")}
            onKeyDown={e => handleKeyDown(e, "teamName")}
            placeholder={team.teamName || "Add team name"}
            style={styles.input}
            autoFocus
          />
        ) : (
          <span onClick={() => setHoverField("teamName")} style={styles.clickable}>
            {team.teamName || <span style={styles.placeholder}></span>}
          </span>
        )}
      </div>

      {/* Playing Style */}
      <div
        style={styles.field}
        onMouseEnter={() => setHoverField("playingStyle")}
        onMouseLeave={() => setHoverField(null)}
      >
        <strong>Playing Style:</strong>{" "}
        {hoverField === "playingStyle" ? (
          <input
            type="text"
            value={editableFields.playingStyle}
            onChange={e => handleInputChange("playingStyle", e.target.value)}
            onBlur={() => commitField("playingStyle")}
            onKeyDown={e => handleKeyDown(e, "playingStyle")}
            placeholder={team.playingStyle || "Add playing style"}
            style={styles.input}
            autoFocus
          />
        ) : (
          <span onClick={() => setHoverField("playingStyle")} style={styles.clickable}>
            {team.playingStyle || <span style={styles.placeholder}></span>}
          </span>
        )}
      </div>

      {/* Owner */}
      <div
        style={styles.field}
        onMouseEnter={() => setHoverField("owner")}
        onMouseLeave={() => setHoverField(null)}
      >
        <strong>Owner:</strong>{" "}
        {hoverField === "owner" ? (
          <input
            type="text"
            value={editableFields.owner}
            onChange={e => handleInputChange("owner", e.target.value)}
            onBlur={() => commitField("owner")}
            onKeyDown={e => handleKeyDown(e, "owner")}
            placeholder={team.owner || "Add owner"}
            style={styles.input}
            autoFocus
          />
        ) : (
          <span onClick={() => setHoverField("owner")} style={styles.clickable}>
            {team.owner || <span style={styles.placeholder}></span>}
          </span>
        )}
      </div>

      {/* Tournament Name */}
      <div
        style={styles.field}
        onMouseEnter={() => setHoverField("tournamentName")}
        onMouseLeave={() => setHoverField(null)}
      >
        <strong>Tournament:</strong>{" "}
        {hoverField === "tournamentName" ? (
          <input
            type="text"
            value={editableFields.tournamentName}
            onChange={e => handleInputChange("tournamentName", e.target.value)}
            onBlur={() => commitField("tournamentName")}
            onKeyDown={e => handleKeyDown(e, "tournamentName")}
            placeholder={team.tournamentAssociatedWithTeamDTO?.tournamentName || "Add tournament"}
            style={styles.input}
            autoFocus
          />
        ) : (
          <span onClick={() => setHoverField("tournamentName")} style={styles.clickable}>
            {team.tournamentAssociatedWithTeamDTO?.tournamentName || <span style={styles.placeholder}></span>}
          </span>
        )}
      </div>
    </div>
  );
}

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
  field: {
    marginBottom: '1rem'
  },
  input: {
    padding: '0.4rem 0.6rem',
    border: '1px solid #ccc',
    borderRadius: '4px',
    fontSize: '1rem',
    width: '100%',
    maxWidth: '300px'
  },
  placeholder: {
    display: 'inline-block',
    minWidth: '120px',
    height: '1.2rem',
    borderBottom: '1px dashed #ccc',
    opacity: 0.4,
    cursor: 'pointer'
  },
  clickable: {
    cursor: 'pointer'
  },
  button: {
    marginTop: '1rem',
    padding: '0.6rem 1.2rem',
    fontSize: '1rem',
    backgroundColor: '#0078D4',
    color: '#fff',
    border: 'none',
    borderRadius: '6px',
    cursor: 'pointer'
  },
  link: {
    display: 'inline-block',
    marginBottom: '1rem',
    color: '#0078D4',
    textDecoration: 'none'
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