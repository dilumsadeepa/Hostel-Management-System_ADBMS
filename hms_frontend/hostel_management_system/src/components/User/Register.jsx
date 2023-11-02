import React from 'react';

const Register = () => {
    return (
        <div className="container">
      <div className="card shadow-lg o-hidden border-0 my-5">
        <div className="card-body p-0">
          <div className="row">
            <div className="col-lg-5 d-none d-lg-flex">
              <div
                className="flex-grow-1 bg-register-image"
                style={{
                  backgroundImage: 'url("assets/img/hostels/1.jpg")',
                }}
              ></div>
            </div>
            <div className="col-lg-7">
              <div className="p-5">
                <div className="text-center">
                  <h4 className="text-dark mb-4">Create an Account!</h4>
                </div>
                <form className="user">
                  <div className="row mb-3">
                    <div className="col-sm-6 mb-3 mb-sm-0">
                      <input
                        className="form-control form-control-user"
                        type="text"
                        id="exampleFirstName"
                        placeholder="First Name"
                        name="first_name"
                      />
                    </div>
                    <div className="col-sm-6">
                      <input
                        className="form-control form-control-user"
                        type="text"
                        id="exampleLastName"
                        placeholder="Last Name"
                        name="last_name"
                      />
                    </div>
                  </div>
                  <div className="mb-3">
                    <input
                      className="form-control form-control-user"
                      type="email"
                      id="exampleInputEmail"
                      aria-describedby="emailHelp"
                      placeholder="Email Address"
                      name="email"
                    />
                  </div>
                  <div className="row mb-3">
                    <div className="col-sm-6 mb-3 mb-sm-0">
                      <input
                        className="form-control form-control-user"
                        type="password"
                        id="examplePasswordInput"
                        placeholder="Password"
                        name="password"
                      />
                    </div>
                    <div className="col-sm-6">
                      <input
                        className="form-control form-control-user"
                        type="password"
                        id="exampleRepeatPasswordInput"
                        placeholder="Repeat Password"
                        name="password_repeat"
                      />
                    </div>
                  </div>
                  <button
                    className="btn btn-primary d-block btn-user w-100"
                    type="submit"
                  >
                    Register Account
                  </button>
                  <hr />
                  
                </form>
                <div className="text-center">
                  <a className="small" href="forgot-password.html">
                    Forgot Password?
                  </a>
                </div>
                <div className="text-center">
                  <a className="small" href="login.html">
                    Already have an account? Login!
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    );
};

export default Register;