import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

dataset=pd.read_csv('test1_dataset.csv')
X = dataset.iloc[:,1].values
Y = dataset.iloc[:,-4].values

'''
from sklearn.model_selection import train_test_split
xtrain,xtest,ytrain,ytest=train_test_split(X,Y,test_size=1/3,random_state=0)
'''

x=X.reshape(-1,1)
from sklearn.linear_model import LinearRegression 
lin = LinearRegression() 
  
lin.fit(x, Y) 

from sklearn.preprocessing import PolynomialFeatures 
  
poly = PolynomialFeatures(degree = 3) 
X_poly = poly.fit_transform(x) 
  
poly.fit(X_poly, Y) 
lin2 = LinearRegression() 
lin2.fit(X_poly, Y) 

# Visualising the Polynomial Regression results 
plt.scatter(x, Y, color = 'blue') 
  
plt.plot(x, lin2.predict(poly.fit_transform(x)), color = 'red') 
plt.title('Polynomial Regression') 
plt.xlabel('Months') 
plt.ylabel('Passengers') 
  
plt.show()

#prediction for 2015 dataset
arr=[13]
arr=np.array(arr)
arr=arr.reshape(-1,1)
lin2.predict(poly.fit_transform(arr)) 
