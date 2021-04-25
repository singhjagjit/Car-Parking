import React, { Component } from "react";
import axios from "axios";

export default class AddCar extends Component {
  state = {
    carId: "",
    carNumber: "",
    ownerId: "",
    carSize: "Small",
    firstName: "",
    lastName: "",
    contactNumber: "",
    lotNumber: "",
    error: "",
    success: "",
  };

  onChange = this.onChange.bind(this);
  onSubmit = this.onSubmit.bind(this);

  componentDidMount() {
    let username = localStorage.username;
    if (!username) {
      this.props.history.push(`/`);
    }
  }

  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

  onSubmit(e) {
    e.preventDefault();

    axios
      .get(`/api/lots/${this.state.carSize}`)
      .then((res) => {
        this.setState({
          lotNumber: res.data[0].lotNumber,
        });

        axios
          .post("/api/owners", {
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            contactNumber: this.state.contactNumber,
          })
          .then((res) => {
            axios
              .post("/api/cars", {
                carNumber: this.state.carNumber,
                ownerId: res.data.ownerId,
                lotNumber: this.state.lotNumber,
                carSize: this.state.carSize,
                entryDateAndTime: new Date().toLocaleString(),
                exitDateAndTime: null,
                amountPaid: null,
                totalTime: null,
              })
              .then((res) => {
                axios
                  .put("/api/lots", {
                    lotNumber: this.state.lotNumber,
                    size: this.state.carSize,
                    empty: false,
                  })
                  .then((res) => {
                    this.setState({
                      success: "Your car is parked successfully!",
                    });

                    window.location = "/cars";
                  })
                  .catch((e) => console.log(e));
              })
              .catch((e) => console.log(e));
          })
          .catch((e) => {
            console.log(e);
          });
      })
      .catch((e) => {
        this.setState({
          error: "An error occured!",
        });
        console.log(e);
      });
  }

  render() {
    let message = "";
    if (this.state.success) {
      message = <p className="success-msg">{this.state.success}</p>;
    } else if (this.state.error) {
      message = <p className="error-msg">{this.state.error}</p>;
    }

    return (
      <>
        <div className="form-container">
          {message}

          <form onSubmit={this.onSubmit}>
            <fieldset className="form-field">
              <legend>Car Details</legend>

              <div className="form-row">
                <label className="form-label">Car Number</label>
                <input
                  required
                  className="form-input"
                  type="text"
                  name="carNumber"
                  value={this.state.carNumber}
                  onChange={this.onChange}
                />
              </div>

              <div className="form-row">
                <label className="form-label">Car Size</label>
                <select
                  className="custom-select"
                  name="carSize"
                  onChange={this.onChange}
                >
                  <option value="Small">Small</option>
                  <option value="Medium">Medium</option>
                  <option value="Large">Large</option>
                </select>
              </div>

              <div className="form-row">
                <label className="form-label">First Name</label>
                <input
                  required
                  className="form-input"
                  type="text"
                  name="firstName"
                  value={this.state.firstName}
                  onChange={this.onChange}
                />
              </div>

              <div className="form-row">
                <label className="form-label">Last Name</label>
                <input
                  required
                  className="form-input"
                  type="text"
                  name="lastName"
                  value={this.state.lastName}
                  onChange={this.onChange}
                />
              </div>

              <div className="form-row">
                <label className="form-label">Contact Number</label>
                <input
                  required
                  className="form-input"
                  type="text"
                  name="contactNumber"
                  value={this.state.contactNumber}
                  onChange={this.onChange}
                />
              </div>
            </fieldset>
            <button type="submit" className="submit-btn">
              Park Car
            </button>
          </form>
          <hr />
        </div>
      </>
    );
  }
}
