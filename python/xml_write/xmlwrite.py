#!/usr/bin/env python

import xml.etree.ElementTree as ET

root = ET.Element('root')

ele_1 = ET.SubElement(root, 'ele-1')
ele_1_1 = ET.SubElement(ele_1, 'ele-1.1')
ele_2 = ET.SubElement(root, 'ele-2')

ET.ElementTree(root).write('conf.xml')

