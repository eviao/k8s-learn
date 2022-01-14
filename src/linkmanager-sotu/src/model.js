import { Sequelize, DataTypes } from 'sequelize';

const MYSQL_ROOT_PASSWORD = process.env.MYSQL_ROOT_PASSWORD;

const sequelize = new Sequelize('linkmanager_db', 'root', MYSQL_ROOT_PASSWORD, {
  host: 'link-db.default.svc.cluster.local',
  dialect: 'mysql',
});

export const Link = sequelize.define(
  'Link',
  {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    name: DataTypes.STRING,
    url: DataTypes.STRING,
    screen: DataTypes.STRING,
  },
  {
    tableName: 'link',
    createdAt: 'created_at',
    updatedAt: 'updated_at',
  }
);

export default sequelize;
