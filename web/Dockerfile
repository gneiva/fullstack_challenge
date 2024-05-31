# Use a imagem oficial do Node.js para construir a aplicação Angular
FROM node:14 AS build

# Defina o diretório de trabalho
WORKDIR /app

# Copie o package.json e o package-lock.json
COPY package*.json ./

# Instale as dependências
RUN npm install

# Copie o restante do código
COPY . .

# Construa a aplicação para produção
RUN npm run build --prod

# Use a imagem do Nginx para servir a aplicação Angular
FROM nginx:alpine

# Copie os arquivos construídos para o diretório padrão do Nginx
COPY --from=build /app/dist/angular /usr/share/nginx/html

# Exponha a porta 80
EXPOSE 80

# Comando para rodar o Nginx
CMD ["nginx", "-g", "daemon off;"]