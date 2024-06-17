import { Input } from "@mui/material";
import styled from "styled-components";

export const ContainerLogin = styled.div`
    width: 100%;
    height: 100vh;
    display: flex;
    justify-content: center; /* Centraliza horizontalmente */
    align-items: center; /* Centraliza verticalmente */
`;

export const FormContainer = styled.div`
    display: flex;
    justify-content: center;
    align-items: center;
    background: black;
    height: 100vh;
    width: 100%; /* Ocupa toda a largura do ContainerLogin */
`;

export const ContainerImage = styled.div`
    display: flex;
    justify-content: center;
    height: 45vw;
    width: 50vw;
`;

export const ImageContent = styled.img`
    object-fit: contain;
`;

export const FormContent = styled.form`
    display: flex;
    flex-direction: column;
    padding: 32px 24px;
    width: 45vw;
    background: linear-gradient(#212121, #212121) padding-box,
                linear-gradient(145deg, transparent 35%, #e81cff, #40c9ff) border-box;
    border: 2px solid transparent;
    font-size: 14px;
    font-family: inherit;
    color: white;
    gap: 20px;
    box-sizing: border-box;
    border-radius: 16px;
`;

export const TitleLogin = styled.h1`
    color: white;
    font-size: 2.5rem;
    margin-bottom: 2rem;
`;

export const ButtonLogin = styled.button`
    font-size: 1.2rem;
    border-radius: 6px;
    height: 3rem;
    margin-top: 8px;
    border: 1px solid #414141;
    background: #313131;
    color: #717171;
    cursor: pointer;
    padding: 12px 16px;
    width: 40%;
    font-family: inherit;

    &:hover {
        background-color: #fff;
        border-color: #fff;
    }
`;

export const InputForm = styled(Input)`
    padding: 12px 16px;
    border-radius: 8px;
    font-size: 1rem;
    width: 100%;
    box-sizing: border-box;
    color: #fff;
    background-color: transparent;
    border: 1px solid #414141;
    

    &::placeholder {
        opacity: 0.5;
        color: white;
    }

    &:focus {
        outline: none;
        border-color: #e81cff;
    }

    &.error {
        border-color: #dc3545;
    }
`;
