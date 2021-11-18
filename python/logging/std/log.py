#!/usr/bin/env python

from sys import stdout
from logging import getLogger
from logging import Logger, Formatter
from logging import DEBUG, INFO, WARNING, ERROR
from logging import StreamHandler
from logging.handlers import RotatingFileHandler

formatter = Formatter('%(asctime)s - %(levelname)s - %(filename)s[:%(lineno)d] - %(message)s', datefmt='%Y-%m-%d %H:%M:%S')

handler_stdout = StreamHandler(stdout)
handler_stdout.setFormatter(formatter)
handler_file = RotatingFileHandler('test.log')
handler_file.setFormatter(formatter)

logger = getLogger('base')
logger.setLevel(DEBUG)
logger.addHandler(handler_stdout)
logger.addHandler(handler_file)

def test_logger():
    logger.debug('this is deb')
    logger.info('this is inf')
    logger.warning('this is war')
    logger.error('this is err')

    logger.log(INFO, 'this is inf too')

if __name__ == '__main__':
    test_logger()

