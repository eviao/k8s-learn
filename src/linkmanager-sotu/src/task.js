import { promise } from 'fastq';
import Pageres from 'pageres';
import { Link } from './model.js';

export const queue = promise(worker, 1);

const outputDir = '/usr/src/app/screenshot';

async function catchScreen(link) {
  const filename = generateFilename(link);
  const format = 'png';

  await new Pageres({
    crop: true,
    filename,
    format,
  })
    .src(link.url, ['480x320'])
    .dest(outputDir)
    .run();

  return `${filename}.${format}`;
}

function generateFilename(model) {
  return model.id.toString();
}

function isURL(url) {
  return /^(http)/.test(url);
}

async function worker({ id }) {
  const link = await Link.findByPk(id);
  if (!link || !isURL(link.url)) {
    return false;
  }

  const filePath = await catchScreen(link);

  link.screen = filePath;
  await link.save();

  return true;
}
