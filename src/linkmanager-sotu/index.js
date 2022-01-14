import express from 'express';
import { queue } from './src/task.js';

const app = express();
const port = 8002;

app.use(express.json());

app.post('/tasks', (req, res) => {
  queue.push(req.body);
  res.json({ success: true });
});

app.listen(port, () => {
  console.log(`listening on any ${port}`);
});
