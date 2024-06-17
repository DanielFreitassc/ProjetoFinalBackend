import { Navigate } from 'react-router-dom';
import { useState } from 'react';
import { useAuth } from '../../context/AuthProvider/useAuth';
import { ButtonLogin, ContainerImage, ContainerLogin, FormContainer, FormContent, ImageContent, InputForm, TitleLogin } from './styles';

export const Login = () => {
    const [login, setLogin] = useState("");
    const [password, setPassword] = useState("");
    const [isAuthenticated, setIsAuthenticated] = useState(false);
    const auth = useAuth();

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            await auth.authenticate(login, password);
            setIsAuthenticated(true);
        } catch (error) {
            console.error("Erro ao autenticar:", error);
        }
    };

    const handleloginChange = (e) => {
        setLogin(e.target.value);
    };

    const handlePasswordChange = (e) => {
        setPassword(e.target.value);
    };

    if (isAuthenticated) {
        return <Navigate to="/" replace={true} />;
    }

    return (
        <ContainerLogin>
            <FormContainer>
                <ContainerImage>
                    <ImageContent src="./images/login.png" alt="" />
                </ContainerImage>
                <FormContent onSubmit={handleSubmit}>
                    <TitleLogin>Bem vindo de volta</TitleLogin>
                    <InputForm
                        type="email"
                        name="username"
                        label="Email"
                        placeholder="Digite seu usuário"
                        onChange={handleloginChange} />
                    <InputForm
                        type="password"
                        name="password"
                        label="Senha"
                        placeholder="Digite sua senha"
                        onChange={handlePasswordChange}
                    />
                    <ButtonLogin type="submit">Login</ButtonLogin>
                </FormContent>
            </FormContainer>
        </ContainerLogin>
    );
};

export default Login;
