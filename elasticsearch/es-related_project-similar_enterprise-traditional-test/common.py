#!/usr/bin/env python

from elasticsearch import Elasticsearch

es_ip = 'localhost'
es_port = '9200'
index_name = 'bidding_test'

es_cli = Elasticsearch('%s:%s' % (es_ip, es_port))

doc_type_parent = 'bidding_enterprise'
doc_type_child = 'related_project_reason'

