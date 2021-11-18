#!/usr/bin/env python
# -*- coding: utf-8 -*-

import sys

reload(sys)
sys.setdefaultencoding('utf8')

import re

MONEY_PARSE_PATTERN = re.compile(ur'^(-?\d*\.?\d*)(万|亿)?(元|[元]?人民币|美元|港元)?$')

def parse_money(a_str, default_unit_val=1, default_coin_type=None):
    """
    return: (value(int or float), coinType)
    return (None, None) if failed, else (value, None) if coinType unrecognized, else (value, coinType)
    params:
        default_unit_val: 缺省单位, int/float型, 仅当a_str为纯数字时 生效
        default_coin_type: 缺省币种, 币种未识别时 生效
    基本元素：数字（支持负数）、单位、币种
    支持的单位：万、亿，不支持单位联合使用
    支持的币种：人民币、美元、港元
    """
    a_str = re.sub(r'\s', '', a_str)
    match_rst = MONEY_PARSE_PATTERN.match(a_str)
    if not match_rst:
        return None, None
    try:
        value = float(match_rst.group(1))
    except:
        return None, None
    unit = match_rst.group(2)
    coin_type = match_rst.group(3)
    # unit处理逻辑
    unit_val = 1
    if unit is None and coin_type is None:
        unit_val = default_unit_val
    if unit:
        if unit == u'万':
            unit_val = 10000
        elif unit == u'亿':
            unit_val = 10000 * 10000
    value *= unit_val
    # 数值类型处理
    if value % 1 == 0:
        value = int(value)
    # coin_type处理逻辑
    if coin_type:
        found = False
        for _type in [ u'人民币', u'美元', u'港元' ]:
            if _type in coin_type:
                coin_type = _type
                found = True
                break
        if not found:
            coin_type = None
    if not coin_type and default_coin_type:
        coin_type = default_coin_type
    return value, coin_type


def test_parse_money():
    for content in [ '26', u'28美元', u'99万', u'89亿人 民币', u'98万元 人民币',
            u'32万美元', u'75亿', u'76亿元', u'28万沙币', u'30个人民币', u'66个羊驼',
            u'98亿港 元', u'2.3港元', u'.9万美元', u'9.人民币', u'7.6', u'0人民币', u'0.0',
            u'-98万美元' ]:
        value, coin_type = parse_money(content, default_unit_val=10000, default_coin_type=u'人民币')
        if value is None: value = 'None'
        else: value = str(value)
        if coin_type is None: coin_type = 'None'
        print( 'origin: %s, value: %s, coin_type: %s' % (content, value, coin_type) )

test_parse_money()

