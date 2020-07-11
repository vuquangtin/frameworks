package com.java8.adv.jls14;

import com.java8.adv.jls14.Global.Cyclic;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class Global {
	class Cyclic {
	}

	void foo() {
		new Cyclic(); // create a Global.Cyclic
		class Cyclic extends Cyclic {
		} // circular definition
		{
			class Local {
			}
			{
				class Local {
				} // compile-time error
			}
			class Local {
			} // compile-time error
			class AnotherLocal {
				void bar() {
					class Local {
					} // ok
				}
			}
		}
		class Local {
		} // ok, not in scope of prior Local
	}
}