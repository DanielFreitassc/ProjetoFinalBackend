import { privateAPi } from "../../services/privateApi";

export function setUserLocalStorage(user) {
  localStorage.setItem("user", JSON.stringify(user));
}

export function getUserLocalStorage(){
  const json = localStorage.getItem("user");
  return json ? JSON.parse(json) : null;
}

export async function LoginRequest(
  login,
  password
) {
  try {
    const response = await privateAPi.post("/auth/login", { login, password });
    return response.data;
  } catch (error) {
    console.error("Erro ao fazer login:", error);
    return null;
  }
}

export async function refreshToken() {
  try {
    const user = getUserLocalStorage();
    if (!user) {
      console.error("Error: usuário não está logado");
      return null;
    }

    const response = await privateAPi.post("/auth/refresh-token", {
      token: user.token,
    });
    if (response.status === 200) {
      user.token = response.data.token;
      setUserLocalStorage(user);
      return response.data;
    }
  } catch (error) {
    console.error("Token error:", error);
  }
  return null;
}