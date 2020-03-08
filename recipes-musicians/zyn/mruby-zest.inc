SUMMARY = "Zyn-Fusion User Interface"
LICENSE = "LGPLv2.1+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = " \
    gitsm://github.com/mruby-zest/mruby-zest-build.git \
    file://0001-mruby-Align-build-to-our-needs.patch \
    file://0002-mruby-zest-Align-build-to-our-needs.patch \
    file://0003-src-osc-bridge-Align-build-to-our-needs.patch \
"
SRCREV = "3f8b82e4c56786ef6f4589640fcfed1fe8c9373a"
PV = "3.0.5+git${SRCPV}"
PE = "1"
S = "${WORKDIR}/git"

inherit python3native

DEPENDS += " \
    ruby-native \
    bison-native \
"

CLEANBROKEN = "1"

do_configure_prepend() {
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
