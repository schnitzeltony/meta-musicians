SUMMARY = "Zyn-Fusion User Interface"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = " \
    gitsm://github.com/mruby-zest/mruby-zest-build.git;protocol=https;branch=master \
    file://0001-mruby-Align-build-to-our-needs.patch \
    file://0002-mruby-zest-Align-build-to-our-needs.patch \
    file://0003-src-osc-bridge-Align-build-to-our-needs.patch \
"
SRCREV = "dd3d45ba333011f2359e86f9a758d9836e53fe5f"
PV = "3.0.6"
PE = "1"
S = "${WORKDIR}/git"

inherit python3native pkgconfig

DEPENDS += " \
    ruby-native \
    bison-native \
"

CLEANBROKEN = "1"

do_configure:prepend() {
    # common
    for pyfile in `grep -rl '/usr/bin/env python$' ${S}`; do
        sed -i 's:/usr/bin/env python:/usr/bin/env python3:' $pyfile
    done
    for pyfile in `grep -rl 'python2' ${S}`; do
        sed -i 's:python2:python3:' $pyfile
    done

    # pugl
    # dummy call -> unpacks waf
    ${S}/deps/pugl/waf configure --prefix=${prefix} ${EXTRA_OECONF} || true
    # hmmm
    sed -i 's:^.*raise StopIteration::g' `find ${S}/deps/pugl/.waf3-* -name '*.py'`
    # -> python3
    2to3 -w -x import `find ${S}/deps/pugl/.waf3-* -name '*.py'`
}
