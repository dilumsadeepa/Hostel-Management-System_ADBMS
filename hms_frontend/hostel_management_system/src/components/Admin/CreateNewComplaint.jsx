import React, {useContext, useEffect, useState} from 'react'
import { Formik, Form, Field, ErrorMessage } from "formik";  //use for form handling
import Apiurl from '../ApiURL';
import * as Yup from "yup";   //use for validation purposes
import axios from 'axios';  
import { useNavigate } from 'react-router-dom' ;



const CreateNewComplaint = () => {



    let navigate = useNavigate();
    const initialValues = {
        userId: '',
        userIndex: '',
        complaint: '',
        resId: '',
        complaintDate: '',
        evidenceImage: '',
        status: ''
    };

    const onSubmit = (data) => {
        console.log(data);
        axios.post(`${Apiurl}/complaint/add`, data)
            .then((response) => { 
            navigate("/");   //return to  root page after creating new post
        });
    };

    //validatins form
    const validationSchema = Yup.object().shape({
        userId: Yup.string().required('User ID is required'),
        userIndex: Yup.string().required('User Index is required'),
        complaint: Yup.string().required('Complaint is required'),
        resId: Yup.number().required('Resource ID is required'),
        complaintDate: Yup.date().required('Complaint Date is required'),
        evidenceImage: Yup.string().required('Evidence Image is required'),
        status: Yup.string().required('Status is required'),
      });

    return (
        <div>


        <div className="d-flex justify-content-center">
        <div className="col-sm-10 debox px-5">
        <Formik initialValues={initialValues} onSubmit={onSubmit} validationSchema={validationSchema}>
             <Form className='formContainer'> 
             <div class="mb-3">
             <label className="my-2">user Id:</label>
                <ErrorMessage name='userId' className="badge rounded-pill text-bg-danger my-3" component='span'  />
                <Field id="inputCreatePost" className={`form-control`} name='userId' placeholder='User Id' autoComplete="off" />
             </div>


                <div class="mb-3">
                <label className="my-2">user Index:</label>
                <ErrorMessage name='userIndex' className="badge rounded-pill text-bg-danger my-3" component='span'  />
                <Field id="inputCreatePost" className={`form-control`} name='userIndex' placeholder='Index No' autoComplete="off" />
                </div>
                

                <div class="mb-3">
                <label className="my-2">Complaint:</label>
                <ErrorMessage name='complaint' className="badge rounded-pill text-bg-danger my-3" component='span'  />
                <Field as="textarea" id="complaint" name="complaint"  className={`form-control`}  placeholder="Your complaint"/>
                </div>
               

             <div class="mb-3">
                <label className="my-2">Resource Id:</label>
                <ErrorMessage name='resId' className="badge rounded-pill text-bg-danger my-3" component='span'  />
                <Field id="resId" name="resId" className={`form-control`} placeholder="Your complaint"/>
            </div>

            <div class="mb-3">   
                <label className="my-2">Complaint Date:</label>
                <ErrorMessage name='complaintDate' className="badge rounded-pill text-bg-danger my-3" component='span'  />
                <Field type="date" id="complaintDate" name="complaintDate" className={`form-control`}  placeholder="Your complaint"/>
             </div>

             <div class="mb-3">  
                <label className="my-2">Evidence Image</label>
                <ErrorMessage name='evidenceImage' className="badge rounded-pill text-bg-danger my-3" component='span'  />
                <Field id="evidenceImage" name="evidenceImage" className={`form-control`}  placeholder="Evidence Image"/>
            </div>

            <div class="mb-3">
                <label className="my-2">Status :</label>
                <ErrorMessage name='status' className="badge rounded-pill text-bg-danger my-3" component='span'  />
                <Field id="status" name="status" className={`form-control`}  placeholder="Status"/>
            </div>


                

                <button type='submit' className="btn btn-primary mt-5">Save</button>
                <a  className="btn btn-outline-danger ms-2 mt-5" href='/complaints'>
                  Cancel
                </a>
            </Form>
        </Formik>
        </div>
    </div>
        </div>
    );
};

export default CreateNewComplaint;