#!/usr/bin/env python

class Comb:
	def __init__(self, seq=None):
		self._stat = dict()
		if seq is not None:
			for data in seq:
				self.push(data)
	def __str__(self):
		_str = 'Comb { '
		mems = []
		for data,count in self._stat.iteritems():
			mems.append( '%s=>%d' % (str(data), count) )
		mems.append( '_hash: %d' % (self.__hash__()) )
		_str =  _str + ', '.join(mems) + ' }'
		return _str
	def __repr__(self):
		return self.__str__()
	def __iter__(self):
		return self._stat.__iter__()
	def itervalues(self):
		return self._stat.itervalues()
	def iteritems(self):
		return self._stat.iteritems()
	def __eq__(self, oth):
		if isinstance(oth, Comb):
			return self._stat == oth._stat
		else: return False
	def copy(self):
		rst = Comb()
		rst._stat = self._stat.copy()
		return rst
	def __len__(self):
		return sum(self._stat.itervalues())
	def push(self, data, count=1):
		if data in self._stat:
			self._stat[data] += count
		else:
			self._stat[data] = count
	def pop(self, data, count=1):
		found = self._stat.get(data)
		if found is not None:
			if found>count:
				self._stat[data] -= count
			else:
				self._stat.pop(data)
	def __isub__(self, oth):
		if oth.__class__ is self.__class__:
			for data,count in oth.iteritems():
				self.pop(data, count)
		return self
	def __hash__(self):
		_hash = 0
		for data,count in self._stat.iteritems():
			_hash = _hash*31 + hash(data)*37 + hash(count)*41
		return _hash

def search_combs(src, dest):
	if dest==0 or dest>len(src): return set()
	if dest==len(src):
		rst = set()
		rst.add(src.copy())
		return rst
	combs = set()
	if dest==1:
		for data in src:
			sub_comb = Comb()
			sub_comb.push(data)
			combs.add(sub_comb)
		return combs
	for data in src:
		comb_rest = src.copy()
		comb_rest.pop(data)
		for sub_comb in search_combs(comb_rest, dest-1):
			comb_new = sub_comb.copy()
			comb_new.push(data)
			combs.add(comb_new)
	return combs

def comb_test():
	nums = Comb()
	nums.push(1)
	nums.push(1, 2)
	nums.push(1)
	nums.push(2)
	nums.push(3, 3)
	nums.pop(1, 2)
	print nums
	oth = Comb()
	oth.push(1,3)
	oth.push(2)
	oth.push(3,2)
	nums -= oth
	print nums

def search_combs_test():
	comb = Comb()
	comb.push(1,2)
	comb.push(2,1)
	comb.push(3,1)
	comb.push(4,1)
	comb.push(5,1)
	combs = search_combs(comb, 6)
	for sub in combs:
		print sub

#comb_test()
#search_combs_test()

