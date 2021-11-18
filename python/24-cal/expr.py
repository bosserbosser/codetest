#!/usr/bin/env python

from comb import *

class Expr:
	def __hash__(self):
		return None
	def __eq__(self, oth):
		return None
	def getVal(self):
		return None

class Val(Expr):
	def __init__(self, val):
		self.val = val
	def __eq__(self, oth):
		return self.__class__==oth.__class__ and self.val==oth.val
	def __hash__(self):
		return self.val
	def getVal(self):
		return self.val
	def __str__(self):
		return self.val.__str__()
	def __repr__(self):
		return self.__str__()

class ExprBin(Expr):
	def __init__(self, e1, e2):
		self.e1 = e1
		self.e2 = e2
	def operHash(self):
		return None
	def __hash__(self):
		_hash = self.operHash()
		h_l = h_h = None
		e1_hash = hash(self.e1)
		e2_hash = hash(self.e2)
		if e1_hash>e2_hash:
			h_l = e2_hash
			h_h = e1_hash
		else:
			h_l = e1_hash
			h_h = e2_hash
		_hash = _hash*31 + h_l
		_hash = _hash*31 + h_h
		return _hash
	def commutative(self):
		return None
	def __eq__(self, oth):
		if self.__class__ != oth.__class__: return False
		eq = (self.e1==oth.e1 and self.e2==oth.e2)
		if (not eq) and self.commutative():
			eq = (self.e1==oth.e2 and self.e2==oth.e1)
		return eq
	def sign(self):
		return None
	def __str__(self):
		return '( %s %s %s )' % (self.e1.__str__(), self.sign(), self.e2.__str__())
	def __repr__(self):
		return self.__str__()

class Add(ExprBin):
	def getVal(self):
		return self.e1.getVal() + self.e2.getVal()
	def operHash(self):
		return 11
	def commutative(self):
		return True
	def sign(self):
		return '+'

class Mns(ExprBin):
	def getVal(self):
		return self.e1.getVal() - self.e2.getVal()
	def operHash(self):
		return 13
	def commutative(self):
		return False
	def sign(self):
		return '-'

class Mtp(ExprBin):
	def getVal(self):
		return self.e1.getVal() * self.e2.getVal()
	def operHash(self):
		return 17
	def commutative(self):
		return True
	def sign(self):
		return '*'

class Dvd(ExprBin):
	def getVal(self):
		return self.e1.getVal() / self.e2.getVal()
	def operHash(self):
		return 19
	def commutative(self):
		return False
	def sign(self):
		return '/'

# src: comb
def search_exprs_all(src):
	if len(src)==0:
		return set()
	if len(src)==1:
		return { Val(next(iter(src))) }
	exprs = set()
	e1_size_max = int( len(src) / 2 )
	for e1_size in range(1, e1_size_max+1):
		combs1 = search_combs(src, e1_size)
		for comb1 in combs1:
			comb2 = src.copy()
			comb2 -= comb1
			exprs1 = search_exprs(comb1)
			exprs2 = search_exprs(comb2)
			for e1 in exprs1:
				for e2 in exprs2:
					val1 = e1.getVal()
					val2 = e2.getVal()
					exprs.add( Add(e1,e2) )
					if val1<val2: exprs.add( Mns(e2,e1) )
					else: exprs.add( Mns(e1,e2) )
					exprs.add( Mtp(e1,e2) )
					if val2!=0 and val1%val2==0: exprs.add( Dvd(e1,e2) )
					elif val1!=0 and val2%val1==0: exprs.add( Dvd(e2,e1) )
	return exprs

def search_exprs_dest(src, dest):
	exprs = set()
	exprs_all = search_exprs_all(src)
	#print 'search_exprs_dest::exprs_all.size: %d' % len(exprs_all)
	for expr in exprs_all:
		if expr.getVal()==dest:
			exprs.add(expr)
	return exprs

def search_exprs(src, dest=None):
	if dest==None:
		return search_exprs_all(src)
	else:
		return search_exprs_dest(src, dest)

def expr_eq_test():
	e1 = Add(Val(1),Val(2))
	e2 = Add(Val(2),Val(1))
	print '%s==%s: %s' % (e1.__str__(), e2.__str__(), str(e1==e2))
	e3 = Dvd(Val(1),Val(2))
	e4 = Dvd(Val(2),Val(1))
	print '%s==%s: %s' % (e3.__str__(), e4.__str__(), str(e3==e4))

def search_exprs_all_test():
	src = Comb()
	src.push(5)
	src.push(6)
	src.push(6)
	src.push(8)
	#src.push(3)
	for expr in search_exprs(src):
		print 'expr: %s' % expr.__str__()

def search_exprs_dest_test():
	src = Comb()
	src.push(1)
	src.push(2)
	src.push(3)
	src.push(4)
	for expr in search_exprs(src, 24):
		print 'expr: %s' % expr.__str__()

#expr_eq_test()
search_exprs_all_test()
#search_exprs_dest_test()

